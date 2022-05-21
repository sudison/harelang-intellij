package org.harelang.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import org.harelang.parser.psi.*

tailrec fun psiTreeWalkupInsideFnBlock(element: PsiElement, consumer: (HareExpression) -> Boolean) {
    if (element is HareFunctionDeclaration) {
        return
    }
    if (element is HareExpression) {
        if (consumer(element)) {
            return
        }
    }

    val nextElement = if (element.prevSibling == null) {
        element.parent
    } else {
        element.prevSibling
    }

    psiTreeWalkupInsideFnBlock(nextElement, consumer)
}

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

fun PsiElement.getLocalReferences(s: String, exactMatch: Boolean = false): List<PsiNameIdentifierOwner> {
    val refs = mutableListOf<PsiNameIdentifierOwner>()
    psiTreeWalkupInsideFnBlock(this) {
        val binding = it.bindingList?.bindings?.bindingList?.find { b ->
            if (exactMatch) {
                b.nameIdentifier?.text == s
            } else {
                b.nameIdentifier?.text?.startsWith(s) ?: false
            }
        }
        if (binding != null) {
            refs.add(binding)
        }
        exactMatch && binding != null
    }
    return refs
}

class HareReference(element: PsiElement, private val ref: PsiNameIdentifierOwner, private val rangeFn: () -> TextRange) :
    PsiPolyVariantReferenceBase<PsiElement>(element) {
    override fun getVariants(): Array<out LookupElement> = LookupElement.EMPTY_ARRAY

    override fun calculateDefaultRangeInElement(): TextRange {
        return rangeFn()
    }
    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val r = mutableListOf<ResolveResult>()
        r.add(PsiElementResolveResult(ref, true))
        return r.toTypedArray()
    }
}