package org.harelang.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import org.harelang.parser.psi.*

fun PsiFile.globalDeclarations(excludeType: Boolean = false): List<PsiNameIdentifierOwner> {
    val types = mutableListOf<PsiNameIdentifierOwner>()

    PsiTreeUtil.collectElementsOfType(this, HareGlobalBinding::class.java).forEach {
        types.add(it)
    }
    PsiTreeUtil.collectElementsOfType(this, HareFunctionDeclaration::class.java).forEach {
        types.add(it)
    }
    PsiTreeUtil.collectElementsOfType(this, HareConstantBinding::class.java).forEach {
        types.add(it)
    }
    if (!excludeType) {
        PsiTreeUtil.collectElementsOfType(this, HareTypeBinding::class.java).forEach {
            types.add(it)
        }
    }
    PsiTreeUtil.collectElementsOfType(this, HareImportPath::class.java).forEach {
        types.add(it)
    }
    return types
}

class HareReference(element: PsiElement, private val id: PsiElement) :
    PsiPolyVariantReferenceBase<PsiElement>(element) {
    override fun getVariants(): Array<out LookupElement> = LookupElement.EMPTY_ARRAY

    override fun calculateDefaultRangeInElement(): TextRange {
        return TextRange.from(id.startOffsetInParent, id.textLength)
    }
    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val r = mutableListOf<ResolveResult>()
        val e = element.containingFile?.globalDeclarations(false)?.find {
            it.nameIdentifier?.text == id.text
        }
        if (e != null) r.add(PsiElementResolveResult(e, true))
        return r.toTypedArray()
    }
}