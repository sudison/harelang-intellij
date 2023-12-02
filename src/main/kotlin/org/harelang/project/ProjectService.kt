package org.harelang.project

import com.intellij.openapi.project.Project
import org.harelang.Bundle

class ProjectService(project: Project) {

    init {
        println(Bundle.message("projectService", project.name))
    }
}
