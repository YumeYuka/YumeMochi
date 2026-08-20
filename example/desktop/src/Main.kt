/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

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
