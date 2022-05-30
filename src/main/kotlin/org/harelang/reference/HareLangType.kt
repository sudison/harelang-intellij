package org.harelang.reference

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.file.PsiDirectoryFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import org.harelang.parser.psi.*


interface HareNamedIdentifier {
    fun name(): String?
    fun psi(): PsiElement
}

open class HareLangType(open val owner: PsiElement) {
    open fun lookup(name: String): List<HareNamedIdentifier> {
        return listOf()
    }

    open fun exactMatch(name: String): HareNamedIdentifier? {
        return null
    }
}

class HareLangEnumType(override val owner: PsiElement, private val enumType: HareEnumType) : HareLangType(owner) {
    override fun lookup(name: String): List<HareNamedIdentifier> {
        return enumType.enumValues.enumValueList.filter { it.nameIdentifier?.text?.startsWith(name) == true }
    }

    override fun exactMatch(name: String): HareNamedIdentifier? {
        return enumType.enumValues.enumValueList.find { it.nameIdentifier?.text == name }
    }
}

class HareLangStructType(override val owner: PsiElement, private val structType: HareStructUnionType) : HareLangType(owner) {
    override fun lookup(name: String): List<HareNamedIdentifier> {
        return structType.structUnionFields?.structUnionFieldList?.filter { it.firstChild?.text?.startsWith(name) == true } ?: listOf()
    }

    override fun exactMatch(name: String): HareNamedIdentifier? {
        return structType.structUnionFields?.structUnionFieldList?.find { it.firstChild?.text == name }
    }
}

fun PsiElement.evaluate(): HareLangType? {
   return when(this) {
        is HareTypeBinding -> this.evaluate()
        is HareStructUnionField -> this.evaluate()
        is HareType -> this.evaluate()
        is HareFunctionDeclaration -> this.evaluate()
        is HareBinding -> this.evaluate()
        is PsiDirectory -> this.evaluate()
        is HareImportPath -> this.evaluate()
        else -> null
    }
}

fun HareImportPath.evaluate(): HareLangType? {
    val dir = this.importIdList.last().hareReference() as ModuleDir
    return ModuleLastDirType(dir.psiDir)
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
        aliasType.symbolList.last().hareReference()?.psi()?.evaluate()
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

fun HareBinding.evaluate(): HareLangType? {
    return if (type == null) {
         expression?.planExpressionList?.firstOrNull()?.structLiteral?.symbolList?.firstOrNull()?.hareReference()?.psi()?.evaluate()
    } else {
        this.type?.evaluate()
    }
}

fun PsiElement.hareReference(): HareNamedIdentifier? {
    return if (this.elementType == HareTypes.SCOPE) {
        this.prevSibling?.hareReference()
    } else if (this is HareSymbol) {
        this.hareReference()
    } else if (this is HarePostfixOp) {
        this.hareReference()
    } else if (this is HarePlanExpression) {
        this.hareReference()
    } else if (this is HareStructLiteral) {
        this.hareReference()
    } else if (this is HareImportId) {
        this.hareReference()
    } else {
        null
    }
}

fun HareStructLiteral.hareReference(): HareNamedIdentifier? {
    return this.symbolList.last()?.hareReference()
}

fun HareSymbol.hareReference(): HareNamedIdentifier? {
    val ps = this.prevSibling
    return if(ps == null) {
        if (parent is HareFieldValue) {
            PsiTreeUtil.findFirstParent(this) {
                it is HareStructLiteral
            }?.hareReference()?.psi()?.evaluate()?.exactMatch(this.firstChild.text)
        } else {
            getLocalReferences(this.firstChild.text, true).firstOrNull() ?: containingFile?.globalDeclarationsInModule()
                ?.find { it.name() == this.firstChild.text }
        }
    } else {
        ps.hareReference()?.psi()?.evaluate()?.exactMatch(this.firstChild.text)
    }
}

fun HarePlanExpression.hareReference(): HareNamedIdentifier? {
    return this.symbol?.hareReference()
}

fun HarePostfixOp.hareReference(): HareNamedIdentifier? {
    if (this.callOp != null) {
        return this.prevSibling.hareReference()
    }
    return this.prevSibling.hareReference()?.psi()?.evaluate()?.exactMatch(this.fieldAccessOp?.lastChild?.text!!)
}

class ModuleDir(p: Project, val f: VirtualFile): HareNamedIdentifier {
    val psiDir = PsiDirectoryFactory.getInstance(p).createDirectory(f)
    override fun name(): String? {
        return f.name
    }

    override fun psi(): PsiElement {
        return psiDir
    }
}

class ModuleDirType(override val owner: PsiDirectory) : HareLangType(owner) {
    override fun lookup(name: String): List<HareNamedIdentifier> {
        val modules = owner.virtualFile.modules().filter { it.name.startsWith(name) } ?: return listOf()
        return modules.map { ModuleDir(owner.project, it) }
    }

    override fun exactMatch(name: String): HareNamedIdentifier? {
        val f = owner.virtualFile.modules().find { it.name == name } ?: return null
        return ModuleDir(owner.project, f)
    }
}

class ModuleLastDirType(override val owner: PsiDirectory) : HareLangType(owner) {
    override fun lookup(name: String): List<HareNamedIdentifier> {
        return owner.globalDeclarationsInModule().filter { it.name()?.startsWith(name) ?: false }
    }

    override fun exactMatch(name: String): HareNamedIdentifier? {
        return owner.globalDeclarationsInModule().find { it.name() == name }
    }
}

fun PsiDirectory.evaluate(): HareLangType? {
    return ModuleDirType(this)
}

fun HareImportId.hareReference(): HareNamedIdentifier? {
    if (this.prevSibling == null) {
        val f = this.containingFile?.originalFile?.virtualFile?.getSourceRoot(this.project)?.modules()
            ?.find { it.name == this.firstChild.text } ?: return null
        return ModuleDir(this.project, f)
    } else {
        return PsiTreeUtil.findSiblingBackward(this, HareTypes.IMPORT_ID, null)?.hareReference()?.psi()?.evaluate()?.exactMatch(this.firstChild.text)
    }

}