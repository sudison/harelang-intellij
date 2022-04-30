package org.harelang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object HareFileType : LanguageFileType(HareLang) {
    override fun getName(): String {
        return "Hare"
    }

    override fun getDescription(): String {
        return "Hare Language"
    }

    override fun getDefaultExtension(): String {
        return "ha"
    }

    override fun getIcon(): Icon? {
        return null
    }
}