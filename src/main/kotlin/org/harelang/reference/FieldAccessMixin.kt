package org.harelang.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

abstract class FieldAccessMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        val ref = node.psi.parent?.prevSibling?.hareReference()?.evaluate()?.exactMatch(node.psi.lastChild.text)
        return if (ref != null) {
            HareReference(this, ref, this::calculateDefaultRangeInElement)
        } else {
            null
        }
    }

    private fun calculateDefaultRangeInElement(): TextRange {
        val s = this.lastChild
        return TextRange.from(s.startOffsetInParent, s.textLength)
    }
}