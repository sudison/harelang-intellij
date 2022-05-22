package org.harelang.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import org.harelang.parser.psi.*

tailrec fun psiTreeWalkupInsideFnBlock(element: PsiElement, consumer: (PsiElement) -> Boolean) {
    if (element is HareFunctionDeclaration) {
        return
    }

    if (consumer(element)) {
        return
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

private fun findIdentifier(e: PsiNameIdentifierOwner, s: String, exactMatch: Boolean = false): Boolean {
    return if (exactMatch) {
        e.nameIdentifier?.text == s
    } else {
        e.nameIdentifier?.text?.startsWith(s) ?: false
    }
}
private fun HareExpression.findIdentifier(s: String, exactMatch: Boolean = false): PsiNameIdentifierOwner? {
   return this.bindingList?.bindings?.bindingList?.find {
       findIdentifier(it, s, exactMatch)
    }
}

private fun HarePrototype.findIdentifier(s: String, exactMatch: Boolean = false): PsiNameIdentifierOwner? {
    return this.parameterList?.parameters?.parameterList?.find {
        findIdentifier(it, s, exactMatch)
    }
}

private fun HareForPredicate.findIdentifier(s: String, exactMatch: Boolean = false): PsiNameIdentifierOwner? {
    return this.bindingList?.bindings?.bindingList?.find { findIdentifier(it, s, exactMatch) }
}

private fun HareMatchCase.findIdentifier(s: String, exactMatch: Boolean = false): PsiNameIdentifierOwner? {
    return if (findIdentifier(this, s, exactMatch)) this else null
}


fun PsiElement.getLocalReferences(s: String, exactMatch: Boolean = false): List<PsiNameIdentifierOwner> {
    val refs = mutableListOf<PsiNameIdentifierOwner>()
    psiTreeWalkupInsideFnBlock(this) {
        val id = when (it) {
            is HareExpression -> it.findIdentifier(s, exactMatch)
            is HarePrototype -> it.findIdentifier(s, exactMatch)
            is HareForPredicate -> it.findIdentifier(s ,exactMatch)
            is HareMatchCase -> it.findIdentifier(s, exactMatch)
            else -> null
        }
        if (id != null) {
            refs.add(id)
        }

        exactMatch && id != null
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