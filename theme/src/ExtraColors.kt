/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtraColor(
    val container: Color,
    val text: Color,
    val icon: Color,
    val stroke: Color,
)

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

fun defaultExtraColors(dark: Boolean): ExtraColors =
    if (dark) darkExtraColors() else lightExtraColors()

fun lightExtraColors(
    gray: ExtraColor =
        ExtraColor(Color(0xFFF1F3F5), Color(0xFF4B5563), Color(0xFF6B7280), Color(0xFFE5E7EB)),
    blue: ExtraColor =
        ExtraColor(Color(0xFFEAF2FF), Color(0xFF2563EB), Color(0xFF3B82F6), Color(0xFFBFDBFE)),
    green: ExtraColor =
        ExtraColor(Color(0xFFEAF7EF), Color(0xFF16803C), Color(0xFF16A34A), Color(0xFFBBF7D0)),
    yellow: ExtraColor =
        ExtraColor(Color(0xFFFFF7D6), Color(0xFF9A6700), Color(0xFFCA8A04), Color(0xFFFDE68A)),
    orange: ExtraColor =
        ExtraColor(Color(0xFFFFF0E0), Color(0xFFC2410C), Color(0xFFEA580C), Color(0xFFFED7AA)),
    red: ExtraColor =
        ExtraColor(Color(0xFFFFE8E8), Color(0xFFDC2626), Color(0xFFEF4444), Color(0xFFFECACA)),
    purple: ExtraColor =
        ExtraColor(Color(0xFFF3E8FF), Color(0xFF7C3AED), Color(0xFF8B5CF6), Color(0xFFDDD6FE)),
    white: ExtraColor =
        ExtraColor(Color.White, Color(0xFF374151), Color(0xFF6B7280), Color(0xFFE5E7EB)),
    surface: ExtraColor =
        ExtraColor(Color(0xFFF7F7F7), Color(0xFF374151), Color(0xFF6B7280), Color(0xFFE5E7EB)),
    whiteDestructive: ExtraColor =
        ExtraColor(Color.White, Color(0xFFDC2626), Color(0xFFEF4444), Color(0xFFFECACA)),
    surfaceDestructive: ExtraColor =
        ExtraColor(Color(0xFFFFF1F2), Color(0xFFE11D48), Color(0xFFF43F5E), Color(0xFFFECDD3)),
): ExtraColors =
    ExtraColors(
        gray,
        blue,
        green,
        yellow,
        orange,
        red,
        purple,
        white,
        surface,
        whiteDestructive,
        surfaceDestructive,
    )

fun darkExtraColors(
    gray: ExtraColor =
        ExtraColor(Color(0xFF2A2D30), Color(0xFFD1D5DB), Color(0xFF9CA3AF), Color(0xFF3F444A)),
    blue: ExtraColor =
        ExtraColor(Color(0xFF172554), Color(0xFF93C5FD), Color(0xFF60A5FA), Color(0xFF1D4ED8)),
    green: ExtraColor =
        ExtraColor(Color(0xFF132A1B), Color(0xFF86EFAC), Color(0xFF4ADE80), Color(0xFF15803D)),
    yellow: ExtraColor =
        ExtraColor(Color(0xFF3A2E05), Color(0xFFFDE68A), Color(0xFFFACC15), Color(0xFFA16207)),
    orange: ExtraColor =
        ExtraColor(Color(0xFF3B1F0B), Color(0xFFFDBA74), Color(0xFFFB923C), Color(0xFFC2410C)),
    red: ExtraColor =
        ExtraColor(Color(0xFF3B1215), Color(0xFFFCA5A5), Color(0xFFF87171), Color(0xFFB91C1C)),
    purple: ExtraColor =
        ExtraColor(Color(0xFF2E174F), Color(0xFFD8B4FE), Color(0xFFC084FC), Color(0xFF7E22CE)),
    white: ExtraColor =
        ExtraColor(Color.White, Color(0xFF111827), Color(0xFF374151), Color(0xFFE5E7EB)),
    surface: ExtraColor =
        ExtraColor(Color(0xFF1F2224), Color(0xFFE5E7EB), Color(0xFFD1D5DB), Color(0xFF3F444A)),
    whiteDestructive: ExtraColor =
        ExtraColor(Color.White, Color(0xFFDC2626), Color(0xFFEF4444), Color(0xFFFECACA)),
    surfaceDestructive: ExtraColor =
        ExtraColor(Color(0xFF3B1215), Color(0xFFFCA5A5), Color(0xFFF87171), Color(0xFFB91C1C)),
): ExtraColors =
    ExtraColors(
        gray,
        blue,
        green,
        yellow,
        orange,
        red,
        purple,
        white,
        surface,
        whiteDestructive,
        surfaceDestructive,
    )
