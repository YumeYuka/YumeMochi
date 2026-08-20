plugins {
    id("yumemochi.android.application")
}

dependencies {
    implementation(project(":example:shared"))
    implementation(libs.androidx.activity.compose)
}
