plugins {
    id("yumemochi.kmp.library")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            implementation(project(":theme"))
            implementation(project(":advanced"))
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
        }
    }
}
