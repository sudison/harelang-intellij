package org.harelang.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class CompilerSettings : Configurable {
    private var mySettingsComponent: SettingComponent? = null
    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent?.getPreferredFocusedComponent()
    }
    override fun createComponent(): JComponent? {
        mySettingsComponent = SettingComponent()
        return mySettingsComponent?.getPanel()
    }

    override fun isModified(): Boolean {
        val settings = CompilerSettingService.getInstance()
        return mySettingsComponent?.getCompilerLocationText() != settings?.compilerLocation &&
                mySettingsComponent?.getStdLibLocationText() != settings?.stdLibLocation
    }

    override fun apply() {
        val settings = CompilerSettingService.getInstance()
        settings?.compilerLocation = mySettingsComponent?.getCompilerLocationText().toString()
        settings?.stdLibLocation = mySettingsComponent?.getStdLibLocationText().toString()
    }

    override fun reset() {
        val settings = CompilerSettingService.getInstance()
        mySettingsComponent?.setCompilerLocationText(settings?.compilerLocation)
        mySettingsComponent?.setStdLibLocationText(settings?.stdLibLocation)
    }

    override fun getDisplayName(): String {
        return "Hare"
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}