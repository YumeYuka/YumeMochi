/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** A semantic foreground and background group for status or lightweight surface content. */
@Immutable
data class ExtraColor(
    val container: Color,
    val text: Color,
    val icon: Color,
    val stroke: Color,
)

/**
 * Supplemental semantic palettes that do not belong to the global primary color scale.
 *
 * Use these tokens for status labels, badges, and destructive actions instead of choosing raw
 * colors at component call sites.
 */
@Immutable
data class ExtraColors(
    val gray: ExtraColor,
    val blue: ExtraColor,
    val green: ExtraColor,
    val yellow: ExtraColor,
    val orange: ExtraColor,
    val red: ExtraColor,
    val purple: ExtraColor,
    val white: ExtraColor,
    val surface: ExtraColor,
    val whiteDestructive: ExtraColor,
    val surfaceDestructive: ExtraColor,
)

/** Returns the library default semantic palettes for the supplied [dark] mode. */
fun defaultExtraColors(
    dark: Boolean,
): ExtraColors = if (dark) darkExtraColors() else lightExtraColors()

/** Creates the default light semantic palettes. Each group may be overridden independently. */
fun lightExtraColors(
    gray: ExtraColor = ExtraColor(
        container = Color(0xFFF1F3F5),
        text = Color(0xFF4B5563),
        icon = Color(0xFF6B7280),
        stroke = Color(0xFFE5E7EB),
    ),
    blue: ExtraColor = ExtraColor(
        container = Color(0xFFEAF2FF),
        text = Color(0xFF2563EB),
        icon = Color(0xFF3B82F6),
        stroke = Color(0xFFBFDBFE),
    ),
    green: ExtraColor = ExtraColor(
        container = Color(0xFFEAF7EF),
        text = Color(0xFF16803C),
        icon = Color(0xFF16A34A),
        stroke = Color(0xFFBBF7D0),
    ),
    yellow: ExtraColor = ExtraColor(
        container = Color(0xFFFFF7D6),
        text = Color(0xFF9A6700),
        icon = Color(0xFFCA8A04),
        stroke = Color(0xFFFDE68A),
    ),
    orange: ExtraColor = ExtraColor(
        container = Color(0xFFFFF0E0),
        text = Color(0xFFC2410C),
        icon = Color(0xFFEA580C),
        stroke = Color(0xFFFED7AA),
    ),
    red: ExtraColor = ExtraColor(
        container = Color(0xFFFFE8E8),
        text = Color(0xFFDC2626),
        icon = Color(0xFFEF4444),
        stroke = Color(0xFFFECACA),
    ),
    purple: ExtraColor = ExtraColor(
        container = Color(0xFFF3E8FF),
        text = Color(0xFF7C3AED),
        icon = Color(0xFF8B5CF6),
        stroke = Color(0xFFDDD6FE),
    ),
    white: ExtraColor = ExtraColor(
        container = Color(0xFFFFFFFF),
        text = Color(0xFF374151),
        icon = Color(0xFF6B7280),
        stroke = Color(0xFFE5E7EB),
    ),
    surface: ExtraColor = ExtraColor(
        container = Color(0xFFF7F7F7),
        text = Color(0xFF374151),
        icon = Color(0xFF6B7280),
        stroke = Color(0xFFE5E7EB),
    ),
    whiteDestructive: ExtraColor = ExtraColor(
        container = Color(0xFFFFFFFF),
        text = Color(0xFFDC2626),
        icon = Color(0xFFEF4444),
        stroke = Color(0xFFFECACA),
    ),
    surfaceDestructive: ExtraColor = ExtraColor(
        container = Color(0xFFFFF1F2),
        text = Color(0xFFE11D48),
        icon = Color(0xFFF43F5E),
        stroke = Color(0xFFFECDD3),
    ),
): ExtraColors = ExtraColors(
    gray = gray,
    blue = blue,
    green = green,
    yellow = yellow,
    orange = orange,
    red = red,
    purple = purple,
    white = white,
    surface = surface,
    whiteDestructive = whiteDestructive,
    surfaceDestructive = surfaceDestructive,
)

/** Creates the default dark semantic palettes. Each group may be overridden independently. */
fun darkExtraColors(
    gray: ExtraColor = ExtraColor(
        container = Color(0xFF2A2D30),
        text = Color(0xFFD1D5DB),
        icon = Color(0xFF9CA3AF),
        stroke = Color(0xFF3F444A),
    ),
    blue: ExtraColor = ExtraColor(
        container = Color(0xFF172554),
        text = Color(0xFF93C5FD),
        icon = Color(0xFF60A5FA),
        stroke = Color(0xFF1D4ED8),
    ),
    green: ExtraColor = ExtraColor(
        container = Color(0xFF132A1B),
        text = Color(0xFF86EFAC),
        icon = Color(0xFF4ADE80),
        stroke = Color(0xFF15803D),
    ),
    yellow: ExtraColor = ExtraColor(
        container = Color(0xFF3A2E05),
        text = Color(0xFFFDE68A),
        icon = Color(0xFFFACC15),
        stroke = Color(0xFFA16207),
    ),
    orange: ExtraColor = ExtraColor(
        container = Color(0xFF3B1F0B),
        text = Color(0xFFFDBA74),
        icon = Color(0xFFFB923C),
        stroke = Color(0xFFC2410C),
    ),
    red: ExtraColor = ExtraColor(
        container = Color(0xFF3B1215),
        text = Color(0xFFFCA5A5),
        icon = Color(0xFFF87171),
        stroke = Color(0xFFB91C1C),
    ),
    purple: ExtraColor = ExtraColor(
        container = Color(0xFF2E174F),
        text = Color(0xFFD8B4FE),
        icon = Color(0xFFC084FC),
        stroke = Color(0xFF7E22CE),
    ),
    white: ExtraColor = ExtraColor(
        container = Color(0xFFFFFFFF),
        text = Color(0xFF111827),
        icon = Color(0xFF374151),
        stroke = Color(0xFFE5E7EB),
    ),
    surface: ExtraColor = ExtraColor(
        container = Color(0xFF1F2224),
        text = Color(0xFFE5E7EB),
        icon = Color(0xFFD1D5DB),
        stroke = Color(0xFF3F444A),
    ),
    whiteDestructive: ExtraColor = ExtraColor(
        container = Color(0xFFFFFFFF),
        text = Color(0xFFDC2626),
        icon = Color(0xFFEF4444),
        stroke = Color(0xFFFECACA),
    ),
    surfaceDestructive: ExtraColor = ExtraColor(
        container = Color(0xFF3B1215),
        text = Color(0xFFFCA5A5),
        icon = Color(0xFFF87171),
        stroke = Color(0xFFB91C1C),
    ),
): ExtraColors = ExtraColors(
    gray = gray,
    blue = blue,
    green = green,
    yellow = yellow,
    orange = orange,
    red = red,
    purple = purple,
    white = white,
    surface = surface,
    whiteDestructive = whiteDestructive,
    surfaceDestructive = surfaceDestructive,
)
