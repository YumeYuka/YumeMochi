/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.yumeyuka.yumemochi.components.toast.ToastDefaults
import moe.yumeyuka.yumemochi.components.toast.ToastHost
import moe.yumeyuka.yumemochi.components.toast.ToastPlacement
import moe.yumeyuka.yumemochi.components.toast.rememberToastHostState
import moe.yumeyuka.yumemochi.theme.MochiTheme
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.theme.ThemeController

@Composable
fun ExampleApp() {
    MochiTheme {
        MiuixTheme(controller = remember { ThemeController() }) {
            val toastHostState = rememberToastHostState()
            val bottomToastHostState = rememberToastHostState()
            val scope = rememberCoroutineScope()
            val successStyle = ToastDefaults.success()
            val warningStyle = ToastDefaults.warning()
            val colors = MochiTheme.colors

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.bgAlt),
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextButton(
                        text = "Show short toast",
                        onClick = {
                            toastHostState.show(
                                title = "Saved",
                                description = "Your changes are synced.",
                                style = successStyle,
                            )
                        },
                    )
                    TextButton(
                        text = "Show detailed toast",
                        onClick = {
                            toastHostState.show(
                                title = "Download completed with additional information",
                                description = "Three files need review before they can be opened. " +
                                    "The remaining files were saved to your Downloads folder.",
                                style = warningStyle,
                            )
                        },
                    )
                    TextButton(
                        text = "Show bottom toast",
                        onClick = {
                            bottomToastHostState.show(
                                title = "Saved",
                                description = "This Toast enters from the bottom.",
                                style = successStyle,
                            )
                        },
                    )
                    TextButton(
                        text = "Long toast then short toast",
                        onClick = {
                            scope.launch {
                                toastHostState.show(
                                    title = "Download completed with additional information",
                                    description = "Three files need review before they can be opened. " +
                                        "The remaining files were saved to your Downloads folder.",
                                    style = warningStyle,
                                )
                                delay(420)
                                toastHostState.show(
                                    title = "Saved",
                                    description = "Your changes are synced.",
                                    style = successStyle,
                                )
                            }
                        },
                    )
                }
                ToastHost(
                    state = toastHostState,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                )
                ToastHost(
                    state = bottomToastHostState,
                    placement = ToastPlacement.Bottom,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                )
            }
        }
    }
}
