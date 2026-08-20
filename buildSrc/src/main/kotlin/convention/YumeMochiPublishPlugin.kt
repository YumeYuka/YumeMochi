package moe.yumeyuka.yumemochi.build.convention

import moe.yumeyuka.yumemochi.build.config.YumeMochiBuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.credentials.PasswordCredentials
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.maven

/** Publishes a KMP module required by the public YumeMochi facade. */
public class YumeMochiPublishPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("maven-publish")

        target.extensions.configure<PublishingExtension> {
            repositories {
                maven {
                    name = "GitHubPackages"
                    url = target.uri("https://maven.pkg.github.com/${YumeMochiBuild.githubRepository}")
                    credentials(PasswordCredentials::class) {
                        username = target.providers.gradleProperty("gpr.user")
                            .orElse(target.providers.environmentVariable("GITHUB_ACTOR"))
                            .orNull
                        password = target.providers.gradleProperty("gpr.key")
                            .orElse(target.providers.environmentVariable("GITHUB_TOKEN"))
                            .orNull
                    }
                }
            }
        }
    }
}
