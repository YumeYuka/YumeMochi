plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(project(":theme"))
            implementation(project(":basic"))
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            api(libs.miuix.blur)
            implementation(libs.miuix.squircle)
        }
    }
}
