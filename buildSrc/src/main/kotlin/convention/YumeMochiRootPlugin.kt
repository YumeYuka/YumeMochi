package moe.yumeyuka.yumemochi.build.convention

import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project

public class YumeMochiRootPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.group = YumeMochiBuild.group
        target.version = YumeMochiBuild.version
    }
}
