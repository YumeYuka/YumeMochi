/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.advanced

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import moe.yumeyuka.yumemochi.theme.MochiTheme
import top.yukonga.miuix.kmp.blur.Backdrop
import top.yukonga.miuix.kmp.blur.blur
import top.yukonga.miuix.kmp.blur.drawBackdrop
import top.yukonga.miuix.kmp.squircle.squircleSurface

/**
 * A clipped glass surface backed by Miuix's runtime-shader blur.
 *
 * Create and attach a Miuix `LayerBackdrop` to the content behind this component, then pass the
 * same instance as [backdrop]. Blur is disabled automatically when runtime shaders are unavailable.
 * Keep this component for transient or small surfaces; blur captures and processes background
 * pixels.
 *
 * ```kotlin
 * val backdrop = rememberLayerBackdrop()
 * Box(Modifier.layerBackdrop(backdrop)) {
 *     BackgroundContent()
 *     MochiGlassSurface(backdrop = backdrop) { ForegroundContent() }
 * }
 * ```
 *
 * @param backdrop Captured content rendered behind this glass surface.
 * @param modifier Modifier applied to the glass container.
 * @param blurRadius Blur radius in dp. Use smaller values for frequently animated surfaces.
 * @param containerColor Overlay color composited over the blurred backdrop.
 * @param cornerRadius Continuous-corner radius used for clipping and the glass background.
 * @param content Content rendered above the blur and overlay.
 */
@Composable
public fun MochiGlassSurface(
    backdrop: Backdrop,
    modifier: Modifier = Modifier,
    blurRadius: Dp = 20.dp,
    containerColor: Color = MochiTheme.colors.bg.copy(alpha = 0.72f),
    cornerRadius: Dp = MochiTheme.radius.md,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier =
            modifier
                .clip(shape)
                .drawBackdrop(
                    backdrop = backdrop,
                    shape = { shape },
                    effects = { blur(blurRadius.toPx()) },
                    onDrawSurface = { drawRect(containerColor) },
                )
                .squircleSurface(color = Color.Transparent, cornerRadius = cornerRadius)
    ) {
        content()
    }
}
