/*
 * Copyright (c) 2026, YumeYuka
 * SPDX-License-Identifier: BSD-3-Clause
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Base color tokens for UI components.
 *
 * The naming follows frontend-style tokens while keeping only the roles required by
 * foundational UI components. Interactive states such as pressed, selected, and soft
 * backgrounds should be derived by components from [brand], [brandAlt], or background colors.
 *
 * @property brand Main theme color for primary actions, selected states, focus states, and key affordances.
 * @property brandAlt Secondary brand color for soft brand backgrounds, current item backgrounds, and secondary selected states.
 * @property onBrand Text or icon color drawn on top of [brand].
 * @property brandDisabled Disabled brand color for disabled primary actions and disabled selected states.
 * @property smartTitle Title color for SmartTitle content that needs more identity than normal text.
 * @property white Fixed white color for content that must stay white.
 * @property black Fixed black color for content that must stay black.
 * @property bg Base page or window background. In light themes this is usually pure white.
 * @property bgAlt Alternative background for inputs, pressed list rows, and grouped areas.
 * @property bgActive Background color for a whole component while it is pressed or actively clicked.
 * @property border Border color for interactive components such as inputs and outlined buttons.
 * @property divider Thin separator color inside components or between list rows.
 * @property text1 Primary text and high-priority icon color.
 * @property text2 Secondary text, supporting copy, and normal muted icon color.
 * @property text3 Placeholder, disabled text, and low-priority icon color.
 * @property disabled Disabled text, icon, and non-interactive content color.
 * @property backdrop Backdrop color behind dialogs, drawers, and blocking overlays.
 */
@Immutable
data class Colors(
    val brand: Color,
    val brandAlt: Color,
    val onBrand: Color,
    val brandDisabled: Color,
    val smartTitle: Color,
    val white: Color,
    val black: Color,
    val bg: Color,
    val bgAlt: Color,
    val bgActive: Color,
    val bgDisabled: Color,
    val bgDisabledAlt: Color,
    val border: Color,
    val divider: Color,
    val text1: Color,
    val text2: Color,
    val text3: Color,
    val backdrop: Color,
)

/**
 * Creates the default light palette.
 *
 * Every parameter is overridable so product code can keep the library's semantic roles while
 * applying a custom brand. Prefer changing a role here instead of hard-coding colors in components.
 */
fun lightColors(
    brand: Color = Color(0xFF166E3F),
    brandAlt: Color = Color(0xFF458B65),
    onBrand: Color = Color(0xFFFFFFFF),
    brandDisabled: Color = Color(0xFFB9D3C5),
    smartTitle: Color = Color(0xFF166E3F),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    bg: Color = Color(0xFFFFFFFF),
    bgAlt: Color = Color(0xFFF5F7F8),
    bgActive: Color = Color(0xFFEEF1EF),
    bgDisabled: Color = Color(0xFFF5F7F8),
    bgDisabledAlt: Color = Color(0xFFE9EAE9),
    border: Color = Color(0xFF166E3F),
    divider: Color = Color(0xFFE9EAE9),
    text1: Color = Color(0xFF171A18),
    text2: Color = Color(0xFF111827),
    text3: Color = Color(0xFF838182),
    backdrop: Color = Color(0x99000000),
): Colors = Colors(
    brand = brand,
    brandAlt = brandAlt,
    onBrand = onBrand,
    brandDisabled = brandDisabled,
    smartTitle = smartTitle,
    white = white,
    black = black,
    bg = bg,
    bgAlt = bgAlt,
    bgActive = bgActive,
    bgDisabled = bgDisabled,
    bgDisabledAlt = bgDisabledAlt,
    border = border,
    divider = divider,
    text1 = text1,
    text2 = text2,
    text3 = text3,
    backdrop = backdrop,
)

/**
 * Creates the default dark palette.
 *
 * Parameters mirror [lightColors] to make a brand override explicit for both color modes.
 */
fun darkColors(
    brand: Color = Color(0xFF26BD6C),
    brandAlt: Color = Color(0xFF209A59),
    onBrand: Color = Color(0xFF180D0C),
    brandDisabled: Color = Color(0xFF0E2A1C),
    smartTitle: Color = Color(0xFF8DDEDE),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    bg: Color = Color(0xFF0A0D0D),
    bgAlt: Color = Color(0xFF121515),
    bgActive: Color = Color(0xFF262827),
    bgDisabled: Color = Color(0xFF1A1D1D),
    bgDisabledAlt: Color = Color(0xFF242527),
    border: Color = Color(0xFF26BD6C),
    divider: Color = Color(0xFF242527),
    text1: Color = Color(0xFFDFE1E0),
    text2: Color = Color(0xFFFFFFFF),
    text3: Color = Color(0xFF9FA1A0),
    backdrop: Color = Color(0x99000000),
): Colors = Colors(
    brand = brand,
    brandAlt = brandAlt,
    onBrand = onBrand,
    brandDisabled = brandDisabled,
    smartTitle = smartTitle,
    white = white,
    black = black,
    bg = bg,
    bgAlt = bgAlt,
    bgActive = bgActive,
    bgDisabled = bgDisabled,
    bgDisabledAlt = bgDisabledAlt,
    border = border,
    divider = divider,
    text1 = text1,
    text2 = text2,
    text3 = text3,
    backdrop = backdrop,
)
