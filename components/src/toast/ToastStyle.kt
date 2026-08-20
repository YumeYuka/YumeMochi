/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.components.toast

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class ToastStyle(
    val icon: ImageVector,
    val containerColor: Color,
    val titleColor: Color,
    val contentColor: Color,
    val iconColor: Color,
)
