package org.harelang.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

abstract class ImportIdMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        val ref = node.psi.hareReference()
        return if (ref != null) {
            HareReference(this, ref, this::calculateDefaultRangeInElement)
        } else {
            null
        }
    }

    private fun calculateDefaultRangeInElement(): TextRange {
        return TextRange.from(this.firstChild.startOffsetInParent, this.firstChild.textLength)
    }
}