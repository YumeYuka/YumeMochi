/*
 * Copyright (c) 2026, YumeYuka
 * SPDX-License-Identifier: BSD-3-Clause
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable

/**
 * Ratio tokens used when a value is derived from another design token.
 */
@Immutable
data class Scale(
    val paragraphLineHeight: Float = 1.3f,
)

/** Default ratios used when [MochiTheme] has no override. */
val DefaultScale = Scale()
