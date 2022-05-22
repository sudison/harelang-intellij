package org.harelang.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.elementType
import org.harelang.parser.psi.*




open class HareLangType(open val owner: PsiElement) {
    open fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return listOf()
    }

    open fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return null
    }
}

class HareLangEnumType(override val owner: PsiElement, private val enumType: HareEnumType) : HareLangType(owner) {
    override fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return enumType.enumValues.enumValueList.filter { it.nameIdentifier?.text?.startsWith(name) == true }
    }

    override fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return enumType.enumValues.enumValueList.find { it.nameIdentifier?.text == name }
    }
}

class HareLangStructType(override val owner: PsiElement, private val structType: HareStructUnionType) : HareLangType(owner) {
    override fun lookup(name: String): List<PsiNameIdentifierOwner> {
        return structType.structUnionFields?.structUnionFieldList?.filter { it.firstChild?.text?.startsWith(name) == true } ?: listOf()
    }

    override fun exactMatch(name: String): PsiNameIdentifierOwner? {
        return structType.structUnionFields?.structUnionFieldList?.find { it.firstChild?.text == name }
    }
}

fun PsiElement.evaluate(): HareLangType? {
   return when(this) {
        is HareTypeBinding -> this.evaluate()
        is HareStructUnionField -> this.evaluate()
        is HareType -> this.evaluate()
        is HareFunctionDeclaration -> this.evaluate()
        else -> null
    }
}

fun HareType.evaluate(): HareLangType? {
    val enumType = this.storageClass.scalaType?.enumType
    val structType = this.storageClass.structUnionType
    val aliasType = this.storageClass.aliasType
    return if (enumType != null) {
        HareLangEnumType(this, enumType)
    } else if (structType != null) {
        HareLangStructType(this, structType)
    } else if (aliasType != null) {
        aliasType.symbolList.last().hareReference()?.evaluate()
    } else {
        null
    }
}

fun HareStructUnionField.evaluate(): HareLangType? {
    return this.type?.evaluate()
}

fun HareTypeBinding.evaluate(): HareLangType? {
    return this.type.evaluate()
}

fun HareFunctionDeclaration.evaluate(): HareLangType? {
    return this.prototype?.type?.evaluate()
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
        getLocalReferences(this.firstChild.text, true).firstOrNull() ?: containingFile?.globalDeclarations()
            ?.find { it.nameIdentifier?.text == this.firstChild.text }
    } else {
        ps.hareReference()?.evaluate()?.exactMatch(this.firstChild.text)
    }
}

fun HarePlanExpression.hareReference(): PsiNameIdentifierOwner? {
    return this.symbol?.hareReference()
}

fun HarePostfixOp.hareReference(): PsiNameIdentifierOwner? {
    if (this.callOp != null) {
        return this.prevSibling.hareReference()
    }
    return this.prevSibling.hareReference()?.evaluate()?.exactMatch(this.fieldAccessOp?.lastChild?.text!!)
}