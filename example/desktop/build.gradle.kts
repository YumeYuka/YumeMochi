plugins {
    id("yumemochi.desktop.application")
}

dependencies {
    implementation(project(":example:shared"))
    implementation(libs.compose.desktop.windows)
}

compose.desktop {
    application {
        mainClass = "moe.yumeyuka.yumemochi.example.desktop.MainKt"
    }
}
