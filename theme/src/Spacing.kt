/*
 * Copyright (c) 2026, YumeYuka
 * SPDX-License-Identifier: BSD-3-Clause
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Layout spacing tokens exposed through [MochiTheme.spacing]. */
@Immutable
data class Spacing(
    val none: Dp = 0.dp,
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val sm: Dp = 6.dp,
    val md: Dp = 8.dp,
    val lg: Dp = 12.dp,
    val xl: Dp = 16.dp,
    val xxl: Dp = 24.dp,
    val xxxl: Dp = 32.dp,
)

/** Default layout spacing used when [MochiTheme] has no override. */
val DefaultSpacing = Spacing()
