/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.example.desktop

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import moe.yumeyuka.yumemochi.example.ExampleApp

fun main(): Unit = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "YumeMochi Example",
        state =
            rememberWindowState(
                width = 450.dp,
                height = 800.dp,
            ),
    ) {
        ExampleApp()
    }
}
