/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.components.toast

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.yumeyucca.lucide.Lucide
import io.github.yumeyucca.lucide.lucide.*
import moe.yumeyuka.yumemochi.theme.MochiTheme

object ToastDefaults {

    @Composable
    fun default(
        icon: ImageVector = Lucide.Info,
        containerColor: Color = MochiTheme.colors.white,
        titleColor: Color = MochiTheme.colors.black,
        contentColor: Color = MochiTheme.colors.black,
        iconColor: Color = titleColor,
    ): ToastStyle = ToastStyle(icon, containerColor, titleColor, contentColor, iconColor)

    @Composable
    fun accent(
        icon: ImageVector = Lucide.BadgeInfo,
        containerColor: Color = MochiTheme.colors.white,
        titleColor: Color = MochiTheme.extraColors.blue.text,
        contentColor: Color = MochiTheme.colors.black,
        iconColor: Color = titleColor,
    ): ToastStyle = ToastStyle(icon, containerColor, titleColor, contentColor, iconColor)

    @Composable
    fun success(
        icon: ImageVector = Lucide.CircleCheck,
        containerColor: Color = MochiTheme.colors.white,
        titleColor: Color = MochiTheme.extraColors.green.text,
        contentColor: Color = MochiTheme.colors.black,
        iconColor: Color = titleColor,
    ): ToastStyle = ToastStyle(icon, containerColor, titleColor, contentColor, iconColor)

    @Composable
    fun warning(
        icon: ImageVector = Lucide.TriangleAlert,
        containerColor: Color = MochiTheme.colors.white,
        titleColor: Color = MochiTheme.extraColors.yellow.text,
        contentColor: Color = MochiTheme.colors.black,
        iconColor: Color = titleColor,
    ): ToastStyle = ToastStyle(icon, containerColor, titleColor, contentColor, iconColor)

    @Composable
    fun error(
        icon: ImageVector = Lucide.CircleX,
        containerColor: Color = MochiTheme.colors.white,
        titleColor: Color = MochiTheme.extraColors.red.text,
        contentColor: Color = MochiTheme.colors.black,
        iconColor: Color = titleColor,
    ): ToastStyle = ToastStyle(icon, containerColor, titleColor, contentColor, iconColor)
}
