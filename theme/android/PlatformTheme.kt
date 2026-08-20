/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle

@Composable
internal actual fun platformColors(dark: Boolean): Colors = if (dark) darkColors() else lightColors()

@Suppress("DEPRECATION")
internal actual fun defaultPlatformTextStyle(): PlatformTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)
