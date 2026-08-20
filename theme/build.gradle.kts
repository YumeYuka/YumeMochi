plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            api(libs.lucide.compose)
        }
    }
}
