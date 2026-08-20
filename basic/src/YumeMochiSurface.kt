/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.basic

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import moe.yumeyuka.yumemochi.theme.MochiTheme
import top.yukonga.miuix.kmp.squircle.squircleSurface

/**
 * Applies a theme-colored Miuix squircle surface to this modifier.
 *
 * Miuix uses a runtime shader where supported and falls back to a regular rounded surface
 * when a platform cannot render squircles.
 *
 * @param cornerRadius Continuous-corner radius. Defaults to [MochiTheme.radius].sm.
 */
@Composable
public fun Modifier.yumeMochiSurface(cornerRadius: Dp = MochiTheme.radius.sm): Modifier =
    squircleSurface(color = MochiTheme.colors.bg, cornerRadius = cornerRadius)
