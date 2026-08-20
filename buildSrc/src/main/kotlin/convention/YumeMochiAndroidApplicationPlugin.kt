/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.build.convention

import com.android.build.api.dsl.ApplicationExtension
import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

public class YumeMochiAndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.group = YumeMochiBuild.group
        target.version = YumeMochiBuild.version

        with(target.pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.compose")
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        target.extensions.configure<ApplicationExtension> {
            namespace = "${YumeMochiBuild.group}.example.android"
            compileSdk = YumeMochiBuild.compileSdk

            defaultConfig {
                applicationId = "${YumeMochiBuild.group}.example"
                minSdk = YumeMochiBuild.minSdk
                targetSdk = YumeMochiBuild.targetSdk
                versionCode = 1
                versionName = YumeMochiBuild.version
            }

            buildFeatures {
                compose = true
            }
        }
    }
}
