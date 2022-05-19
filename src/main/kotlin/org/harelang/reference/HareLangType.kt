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

class HareLangStructType(override val owner: PsiNameIdentifierOwner, private val structType: HareStructUnionType) : HareLangType(owner) {
    override fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return structType.structUnionFields?.structUnionFieldList?.filter { it.firstChild?.text?.startsWith(name) == true } ?: listOf()
    }

    override fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return structType.structUnionFields?.structUnionFieldList?.find { it.firstChild?.text == name }
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
    val structType = this.type.storageClass.structUnionType
    return if (enumType != null) {
        HareLangEnumType(this, enumType)
    } else if (structType != null) {
        HareLangStructType(this, structType)
    } else {
        null
    }
}

fun PsiElement.hareReference(): PsiNameIdentifierOwner? {
    return if (this.elementType == HareTypes.SCOPE) {
        this.prevSibling?.hareReference()
    } else if (this is HareSymbol) {
        this.hareReference()
    } else if (this is HarePostfixOp) {
        this.hareReference()
    } else if (this is HarePlanExpression) {
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

fun HarePlanExpression.hareReference(): PsiNameIdentifierOwner? {
    return this.symbol?.hareReference()
}

fun HarePostfixOp.hareReference(): PsiNameIdentifierOwner? {
    return null
    //return this.prevSibling.hareReference()?.evaluate()?.exactMatch(this.fieldAccessOp?.symbol?.firstChild?.text!!)
}