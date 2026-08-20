plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(project(":theme"))
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.miuix.squircle)
        }
    }
}
