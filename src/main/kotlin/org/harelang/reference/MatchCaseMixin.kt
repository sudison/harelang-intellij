package org.harelang.reference

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import org.harelang.parser.psi.HareTypes

open class MatchCaseMixin(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getName(): String? = nameIdentifier?.text

    override fun getTextOffset(): Int {
        val offset = nameIdentifier?.textOffset
        return offset ?: super.getTextOffset()
    }

    override fun getNameIdentifier(): PsiElement? {
        return node.findChildByType(HareTypes.IDENTIFIER)?.psi
    }

}