package moe.yumeyuka.yumemochi.build.convention

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

public class YumeMochiKmpLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.group = YumeMochiBuild.group
        target.version = YumeMochiBuild.version

        with(target.pluginManager) {
            apply("org.jetbrains.kotlin.multiplatform")
            apply("com.android.kotlin.multiplatform.library")
            apply("org.jetbrains.compose")
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        val kotlinExtension = target.extensions.getByType(KotlinMultiplatformExtension::class.java)
        kotlinExtension.apply {
            jvm("desktop")
            sourceSets.getByName("commonMain").kotlin.srcDir("src")
            sourceSets.getByName("androidMain").kotlin.srcDir("android")
            sourceSets.getByName("desktopMain").kotlin.srcDir("desktop")
        }

        (kotlinExtension as ExtensionAware).extensions.configure<KotlinMultiplatformAndroidLibraryExtension>("android") {
            namespace = YumeMochiBuild.namespace(target.path)
            compileSdk = YumeMochiBuild.compileSdk
            minSdk = YumeMochiBuild.minSdk
        }
    }
}
