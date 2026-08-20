plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(project(":theme"))
            implementation(libs.compose.animation)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.miuix.ui)
            api(libs.miuix.blur)
            api(libs.miuix.squircle)
        }
    }
}
