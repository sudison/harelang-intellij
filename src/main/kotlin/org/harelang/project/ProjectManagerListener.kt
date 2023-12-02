package org.harelang.project

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import org.harelang.project.ProjectService

internal class ProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<ProjectService>()
    }
}
