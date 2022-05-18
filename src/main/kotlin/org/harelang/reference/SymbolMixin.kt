package org.harelang.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        val ref = node.psi.hareReference()
        return if (ref != null) {
            HareReference(this, ref)
        } else {
            null
        }
    }
}