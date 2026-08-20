plugins {
    id("yumemochi.kmp.library")
    id("yumemochi.publish")
}

kotlin {
    sourceSets {
        getByName("commonMain").dependencies {
            api(project(":theme"))
            api(project(":basic"))
            api(project(":advanced"))
        }
    }
}
