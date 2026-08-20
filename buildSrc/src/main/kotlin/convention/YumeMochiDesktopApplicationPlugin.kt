/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.build.convention

import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

public class YumeMochiDesktopApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.group = YumeMochiBuild.group
        target.version = YumeMochiBuild.version

        with(target.pluginManager) {
            apply("org.jetbrains.kotlin.jvm")
            apply("org.jetbrains.compose")
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        target.extensions.configure<KotlinJvmProjectExtension> {
            jvmToolchain(YumeMochiBuild.jvmToolchain)
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_25)
            }
            sourceSets.getByName("main").kotlin.srcDir("src")
        }
    }
}
