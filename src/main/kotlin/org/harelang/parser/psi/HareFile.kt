package org.harelang.parser.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.harelang.HareFileType
import org.harelang.HareLang

class HareFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, HareLang) {
    override fun getFileType() = HareFileType
}