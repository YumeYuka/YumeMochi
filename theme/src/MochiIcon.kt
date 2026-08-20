/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

/**
 * Renders a Lucide [ImageVector] using the active [MochiTheme] icon token.
 *
 * @param imageVector Icon supplied by Lucide, for example `Lucide.Info`.
 * @param contentDescription Accessibility label. Pass `null` only for decorative icons.
 * @param modifier Modifier applied before the icon's fixed [size].
 * @param tint Icon color; defaults to the theme's primary content color.
 * @param size Rendered square size; defaults to [MochiTheme.iconSize].md.
 */
@Composable
public fun MochiIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = MochiTheme.colors.text1,
    size: Dp = MochiTheme.iconSize.md,
) {
    Image(
        painter = rememberVectorPainter(imageVector),
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(tint),
    )
}
