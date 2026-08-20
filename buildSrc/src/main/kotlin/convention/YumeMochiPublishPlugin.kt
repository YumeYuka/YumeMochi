/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.build.convention

import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure

/** Publishes a KMP module required by the public YumeMochi facade. */
public class YumeMochiPublishPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("maven-publish")

        target.extensions.configure<PublishingExtension> {
            publications.withType(MavenPublication::class.java).configureEach {
                if (target.path == ":library") {
                    artifactId = "yumemochi"
                }
            }
            repositories {
                maven {
                    name = "GitHubPackages"
                    url =
                        target.uri(
                            "https://maven.pkg.github.com/${YumeMochiBuild.githubRepository}"
                        )
                    credentials(PasswordCredentials::class.java) {
                        username =
                            target.providers
                                .gradleProperty("gpr.user")
                                .orElse(target.providers.environmentVariable("GITHUB_ACTOR"))
                                .orNull
                        password =
                            target.providers
                                .gradleProperty("gpr.key")
                                .orElse(target.providers.environmentVariable("GITHUB_TOKEN"))
                                .orNull
                    }
                }
            }
        }
    }
}
