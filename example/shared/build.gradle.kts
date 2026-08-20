plugins {
    id("yumemochi.kmp.library")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(project(":theme"))
            implementation(project(":components"))
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.miuix.ui)
        }
    }
}
