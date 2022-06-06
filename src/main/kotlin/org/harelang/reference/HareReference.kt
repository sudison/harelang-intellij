package org.harelang.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.util.elementType
import org.harelang.HareFileType
import org.harelang.parser.psi.*
import org.harelang.settings.CompilerSettingService

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

    if (nextElement == null) {
        return
    }

    psiTreeWalkupInsideFnBlock(nextElement, consumer)
}

private fun PsiFile.globalDeclarationsInFile(exportedOnly: Boolean = true, includeImport: Boolean = false): List<HareNamedIdentifier> {
    val types = mutableListOf<HareNamedIdentifier>()

    this.children.forEach {
        when(it) {
            is HareDeclarations ->
                it.generalDeclarationList.forEach { gdlit ->
                    if (!(exportedOnly && gdlit.firstChild.elementType != HareTypes.EXPORT_KW)) {
                        gdlit.functionDeclaration?.let { fit -> types.add(fit) }
                        gdlit.constantDeclaration?.constantBindings?.constantBindingList?.forEach { cit ->
                            types.add(cit)
                        }
                        gdlit.globalDeclaration?.globalBindings?.globalBindingList?.forEach { git ->
                            types.add(git)
                        }
                        gdlit.typeDeclaration?.typeBindings?.typeBindingList?.forEach { tit ->
                            types.add(tit)
                        }
                    }
                }

            is HareImports ->
                if (includeImport) {
                    it.useStatementList.forEach { uit ->
                        uit.importPath?.let { ipit -> types.add(ipit) }
                    }
                }
        }
    }
    return types
}

fun getCompilerSettings(): CompilerSettingService {
    return ApplicationManager.getApplication().getService(CompilerSettingService::class.java)
}

fun Project.stdLibDir(): VirtualFile? {
    if (getCompilerSettings().stdLibLocation == "") {
        return null
    }

    val fs = LocalFileSystem.getInstance()
    return fs.refreshAndFindFileByPath(getCompilerSettings().stdLibLocation)
}

fun VirtualFile.getSourceRoot(project: Project): VirtualFile? {

    fun guessRootDir(): VirtualFile? {
        val root = project.guessProjectDir()
        if (root?.name == ".idea") {
            return root.parent
        }
        return root
    }

    return ProjectRootManager.getInstance(project).fileIndex.getSourceRootForFile(this)
        ?: guessRootDir()
}

fun VirtualFile.rootDirs(project: Project): List<VirtualFile> {
    val sourceRoot = getSourceRoot(project)
    return listOfNotNull(sourceRoot, project.stdLibDir())
}

fun VirtualFile.modules(): List<VirtualFile> {
    return VfsUtil.getChildren(this) {
        it.isDirectory
    }
}

fun PsiDirectory.globalDeclarationsInModule(): List<HareNamedIdentifier> {
    val types = mutableListOf<HareNamedIdentifier>()
    val files = VfsUtil.getChildren(this.virtualFile) {
        it.fileType == HareFileType
    }

    files.forEach {
        this.manager.findFile(it)?.globalDeclarationsInFile()?.let { it1 -> types.addAll(it1) }
    }
    return types
}

fun PsiFile.globalDeclarationsInModule(): List<HareNamedIdentifier> {
    val types = mutableListOf<HareNamedIdentifier>()

    val pfile = this.originalFile.parent?.virtualFile
    if (pfile != null) {
        val files = VfsUtil.getChildren(pfile) {
            it.fileType == HareFileType
        }

        files.forEach {
            val includeImport = this.originalFile.name == it.name
            this.manager.findFile(it)?.globalDeclarationsInFile(exportedOnly = false, includeImport)?.let { it1 -> types.addAll(it1) }
        }
    }

    return types
}


private fun findIdentifier(e: HareNamedIdentifier, s: String, exactMatch: Boolean = false): Boolean {
    return if (exactMatch) {
        e.name() == s
    } else {
        e.name()?.startsWith(s) ?: false
    }
}
private fun HareExpression.findIdentifier(s: String, exactMatch: Boolean = false): HareNamedIdentifier? {
   return this.bindingList?.bindings?.bindingList?.find {
       findIdentifier(it, s, exactMatch)
    }
}

private fun HarePrototype.findIdentifier(s: String, exactMatch: Boolean = false): HareNamedIdentifier? {
    return this.parameterList?.parameters?.parameterList?.find {
        findIdentifier(it, s, exactMatch)
    }
}

private fun HareForPredicate.findIdentifier(s: String, exactMatch: Boolean = false): HareNamedIdentifier? {
    return this.bindingList?.bindings?.bindingList?.find { findIdentifier(it, s, exactMatch) }
}

private fun HareMatchCase.findIdentifier(s: String, exactMatch: Boolean = false): HareNamedIdentifier? {
    return if (findIdentifier(this, s, exactMatch)) this else null
}


fun PsiElement.getLocalReferences(s: String, exactMatch: Boolean = false): List<HareNamedIdentifier> {
    val refs = mutableListOf<HareNamedIdentifier>()
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

class HareReference(element: PsiElement, private val ref: HareNamedIdentifier, private val rangeFn: () -> TextRange) :
    PsiPolyVariantReferenceBase<PsiElement>(element) {
    override fun getVariants(): Array<out LookupElement> = LookupElement.EMPTY_ARRAY

    override fun calculateDefaultRangeInElement(): TextRange {
        return rangeFn()
    }
    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val r = mutableListOf<ResolveResult>()
        r.add(PsiElementResolveResult(ref.psi(), true))
        return r.toTypedArray()
    }
}