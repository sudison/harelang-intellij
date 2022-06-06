package org.harelang.project

import com.intellij.openapi.project.Project
import org.jetbrains.plugins.template.MyBundle

class ProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
