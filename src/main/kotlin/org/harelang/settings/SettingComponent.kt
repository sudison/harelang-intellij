package org.harelang.settings

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class SettingComponent {
    private var myMainPanel: JPanel? = null
    private val compilerLocation = TextFieldWithBrowseButton()
    private val stdLibLocation = TextFieldWithBrowseButton()
    init {
        compilerLocation.addBrowseFolderListener("Select Hare Compiler Location", null, null, FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor())
        stdLibLocation.addBrowseFolderListener("Select Hare Stdlib Location", null, null, FileChooserDescriptorFactory.createSingleFolderDescriptor())

        myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Hare compiler location:"), compilerLocation, 1, false)
            .addLabeledComponent(JBLabel("Hare stdlib location:"), stdLibLocation, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

    fun getPreferredFocusedComponent(): JComponent? {
        return compilerLocation
    }

    fun getCompilerLocationText(): String? {
        return compilerLocation.text
    }

    fun setCompilerLocationText(newText: String?) {
        compilerLocation.text = newText ?: ""
    }

    fun getStdLibLocationText(): String? {
        return stdLibLocation.text
    }

    fun setStdLibLocationText(newText: String?) {
        stdLibLocation.text = newText ?: ""
    }
}