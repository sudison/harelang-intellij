package org.harelang.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.harelang.parser.psi.HareEnumLiteral
import org.harelang.parser.psi.HarePlanExpression

abstract class SymbolMixin(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        return when(parent) {
            is HarePlanExpression, is HareEnumLiteral -> HareReference(this, node.firstChildNode?.psi!!)
            else -> null
        }
    }
}