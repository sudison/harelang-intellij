package org.harelang.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil


@State(name = "org.harelang.settings.CompilerSettingService", storages = [
    Storage("HareCompilerSettings.xml")
])
class CompilerSettingService : PersistentStateComponent<CompilerSettingService> {
    var compilerLocation = ""
    var stdLibLocation = ""

    companion object {
        fun getInstance(): CompilerSettingService? {
            return ApplicationManager.getApplication().getService(CompilerSettingService::class.java)
        }
    }

    override fun getState(): CompilerSettingService? {
        return this
    }

    override fun loadState(state: CompilerSettingService) {
        XmlSerializerUtil.copyBean(state, this)
    }
}