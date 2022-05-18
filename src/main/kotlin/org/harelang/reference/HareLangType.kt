package org.harelang.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.elementType
import org.harelang.parser.psi.*

open class HareLangType(open val owner: PsiNameIdentifierOwner) {
    open fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return listOf()
    }

    open fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return null
    }
}

class HareLangEnumType(override val owner: PsiNameIdentifierOwner, private val enumType: HareEnumType) : HareLangType(owner) {
    override fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return enumType.enumValues.enumValueList.filter { it.nameIdentifier?.text?.startsWith(name) == true }
    }

    override fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return enumType.enumValues.enumValueList.find { it.nameIdentifier?.text == name }
    }
}

fun PsiNameIdentifierOwner.evaluate(): HareLangType? {
   return when(this) {
        is HareTypeBinding -> this.evaluate()
        else -> null
    }
}


fun HareTypeBinding.evaluate(): HareLangType? {
    val enumType = this.type.storageClass.scalaType?.enumType
    return if (enumType != null) {
        HareLangEnumType(this, enumType)
    } else {
        null
    }
}

fun PsiElement.hareReference(): PsiNameIdentifierOwner? {
    return if (this.elementType == HareTypes.SCOPE) {
        this.prevSibling?.hareReference()
    } else if (this is HareSymbol) {
        this.hareReference()
    } else {
        null
    }
}

fun HareSymbol.hareReference(): PsiNameIdentifierOwner? {
    val ps = this.prevSibling
    return if(ps == null) {
        containingFile?.globalDeclarations()?.find { it.nameIdentifier?.text == this.firstChild.text }
    } else {
        ps.hareReference()?.evaluate()?.exactMatch(this.firstChild.text)
    }
}