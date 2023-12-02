package org.harelang.reference

import com.intellij.injected.editor.VirtualFileWindow
import com.intellij.lang.injection.InjectedLanguageManager
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import org.harelang.parser.psi.HareTypes
import kotlin.math.min

fun replaceCaretMarker(text: String): String = text.replace("/*caret*/", "<caret>")

class InlineFile(fixture: CodeInsightTestFixture, private val code: String, val name: String) {
    private val hasCaretMarker = "/*caret*/" in code || "<caret>" in code

    init {
        fixture.configureByText(name, replaceCaretMarker(code))
    }

    fun withCaret() {
        check(hasCaretMarker) {
            "Please, add `/*caret*/` or `<caret>` marker to\n$code"
        }
    }
}

fun <T : PsiElement> findElementsWithDataAndOffsetInEditorInFile(
    file: PsiFile,
    doc: Document,
    psiClass: Class<T>,
    marker: String
): List<Triple<T, String, Int>> {
    val commentPrefix = "//"
    val caretMarker = "$commentPrefix$marker"
    val text = file.text
    val result = mutableListOf<Triple<T, String, Int>>()
    var markerOffset = -caretMarker.length
    while (true) {
        markerOffset = text.indexOf(caretMarker, markerOffset + caretMarker.length)
        if (markerOffset == -1) break
        val data = text.drop(markerOffset).removePrefix(caretMarker).takeWhile { it != '\n' }.trim()
        val markerEndOffset = markerOffset + caretMarker.length - 1
        val markerLine = doc.getLineNumber(markerEndOffset)
        val makerColumn = markerEndOffset - doc.getLineStartOffset(markerLine)
        val elementOffset =
            min(doc.getLineStartOffset(markerLine - 1) + makerColumn, doc.getLineEndOffset(markerLine - 1))
        val elementAtMarker = file.findElementAt(elementOffset)!!

        val element = PsiTreeUtil.getParentOfType(elementAtMarker, psiClass, false)
        if (element != null) {
            result.add(Triple(element, data, elementOffset))
        } else {
            val injectionElement = InjectedLanguageManager.getInstance(file.project)
                .findInjectedElementAt(file, elementOffset)
                ?.let { PsiTreeUtil.getParentOfType(it, psiClass, false) }
                ?: error("No ${psiClass.simpleName} at ${elementAtMarker.text}")
            val injectionOffset = (injectionElement.containingFile.virtualFile as VirtualFileWindow)
                .documentWindow.hostToInjected(elementOffset)
            result.add(Triple(injectionElement, data, injectionOffset))
        }
    }
    return result
}

val PsiFile.document: Document?
    get() = PsiDocumentManager.getInstance(project).getDocument(this)
val PsiElement.startOffset: Int
    get() = textRange.startOffset

fun PsiElement.findReference(offset: Int): PsiReference? = findReferenceAt(offset - startOffset)
fun PsiElement.checkedResolve(offset: Int, errorMessagePrefix: String = ""): PsiElement {
    val reference = findReference(offset) ?: error("element doesn't have reference")
    val resolved = reference.resolve() ?: run {
        val multiResolve = (reference as? HareReference)?.multiResolve(true).orEmpty()
        check(multiResolve.size != 1)
        if (multiResolve.isEmpty()) {
            error("${errorMessagePrefix}Failed to resolve $text")
        } else {
            error("${errorMessagePrefix}Failed to resolve $text, multiple variants:\n${multiResolve.joinToString()}")
        }
    }

    check(reference.isReferenceTo(resolved)) {
        "Incorrect `isReferenceTo` implementation in `${reference.javaClass.name}`"
    }

    return resolved
}

abstract class ReferenceTestBase : BasePlatformTestCase() {
    fun <T : PsiElement> findElementsWithDataAndOffsetInEditor(
        psiClass: Class<T>,
        marker: String
    ): List<Triple<T, String, Int>> {
        return findElementsWithDataAndOffsetInEditorInFile(
            myFixture.file,
            myFixture.file.document!!,
            psiClass,
            marker
        )
    }

    fun <T : PsiElement> findElementInEditor(psiClass: Class<T>, marker: String): T {
        val (element, data) = findElementWithDataAndOffsetInEditor(psiClass, marker)
        check(data.isEmpty()) { "Did not expect marker data" }
        return element
    }

    fun <T : PsiElement> findElementWithDataAndOffsetInEditor(
        psiClass: Class<T>,
        marker: String
    ): Triple<T, String, Int> {
        val elementsWithDataAndOffset = findElementsWithDataAndOffsetInEditor(psiClass, marker)
        check(elementsWithDataAndOffset.isNotEmpty()) { "No `$marker` marker:\n${myFixture.file.text}" }
        check(elementsWithDataAndOffset.size <= 1) { "More than one `$marker` marker:\n${myFixture.file.text}" }
        return elementsWithDataAndOffset.first()
    }

    fun <R : PsiElement, T : PsiElement> checkReference(
        referenceClass: Class<R>,
        targetPsiClass: Class<T>,
        code: String,
        fileName: String = "main.ha"
    ) {
        InlineFile(myFixture, code, fileName)
        val (refElement, data, offset) = findElementsWithDataAndOffsetInEditorInFile(
            myFixture.file,
            myFixture.file.document!!, referenceClass, "^"
        ).first()
        val resolved = refElement.checkedResolve(offset)

        val target = findElementInEditor(targetPsiClass, "X")

        check(resolved == target) {
            "$refElement `${refElement.text}` should resolve to $target (${target.text}), was $resolved (${resolved.text}) instead"
        }
    }
}