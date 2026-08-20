/*
 * Copyright (c) 2026, YumeYuka
 * SPDX-License-Identifier: BSD-3-Clause
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Standard square icon dimensions exposed through [MochiTheme.iconSize]. */
@Immutable
data class IconSizes(
    val xs: Dp = 12.dp,
    val sm: Dp = 16.dp,
    val md: Dp = 20.dp,
    val lg: Dp = 24.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 40.dp,
)

/** Default icon dimensions used when [MochiTheme] has no override. */
val DefaultIconSizes = IconSizes()
