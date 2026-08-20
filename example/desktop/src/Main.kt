package moe.yumeyuka.yumemochi.example.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import moe.yumeyuka.yumemochi.example.ExampleApp

public fun main(): Unit = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "YumeMochi Example",
    ) {
        ExampleApp()
    }
}
