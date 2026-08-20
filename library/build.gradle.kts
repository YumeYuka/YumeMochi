// Public facade: consumers depend on this module instead of individual component modules.
plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            api(project(":theme"))
            api(project(":components"))
        }
    }
}
