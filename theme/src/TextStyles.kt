/*
 * Copyright (c) 2026, YumeYuka
 * SPDX-License-Identifier: BSD-3-Clause
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Font size tokens used to create [TextStyles].
 *
 * Values are expressed in `sp` by default and are therefore scaled by the user's font setting.
 */
@Immutable
data class TextSizes(
    val main: TextUnit = 17.sp,
    val body1: TextUnit = 16.sp,
    val body2: TextUnit = 14.sp,
    val paragraph: TextUnit = 17.sp,
    val button: TextUnit = 17.sp,
    val footnote1: TextUnit = 13.sp,
    val footnote2: TextUnit = 11.sp,
    val headline1: TextUnit = 18.sp,
    val headline2: TextUnit = 16.sp,
    val subtitle: TextUnit = 14.sp,
    val title1: TextUnit = 32.sp,
    val title2: TextUnit = 24.sp,
    val title3: TextUnit = 20.sp,
    val title4: TextUnit = 18.sp,
)

/** Text style tokens exposed through [MochiTheme.textStyles]. */
@Immutable
data class TextStyles(
    val main: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val paragraph: TextStyle,
    val button: TextStyle,
    val footnote1: TextStyle,
    val footnote2: TextStyle,
    val headline1: TextStyle,
    val headline2: TextStyle,
    val subtitle: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
)

/** Default font-size scale used when [MochiTheme] has no override. */
val DefaultTextSizes = TextSizes()

/**
 * Creates the standard typography set.
 *
 * @param textSizes Font-size scale used to construct default styles.
 * @param scale Ratios applied to derived values such as paragraph line height.
 * @param main Default general-purpose body text.
 * @param body1 Primary body copy.
 * @param body2 Compact body copy.
 * @param paragraph Multi-line body copy with an explicit line height.
 * @param button Medium-weight control label.
 * @param footnote1 Supporting small copy.
 * @param footnote2 The smallest supporting copy.
 * @param headline1 Prominent section heading.
 * @param headline2 Compact section heading.
 * @param subtitle Bold supporting heading.
 * @param title1 Largest page title.
 * @param title2 Large page title.
 * @param title3 Standard page title.
 * @param title4 Compact page title.
 */
fun defaultTextStyles(
    textSizes: TextSizes = DefaultTextSizes,
    scale: Scale = DefaultScale,
    main: TextStyle = TextStyle(
        fontSize = textSizes.main,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    body1: TextStyle = TextStyle(
        fontSize = textSizes.body1,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    body2: TextStyle = TextStyle(
        fontSize = textSizes.body2,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    paragraph: TextStyle = TextStyle(
        fontSize = textSizes.paragraph,
        fontWeight = FontWeight.Normal,
        lineHeight = textSizes.paragraph * scale.paragraphLineHeight,
        platformStyle = defaultPlatformTextStyle(),
    ),
    button: TextStyle = TextStyle(
        fontSize = textSizes.button,
        fontWeight = FontWeight.Medium,
        platformStyle = defaultPlatformTextStyle(),
    ),
    footnote1: TextStyle = TextStyle(
        fontSize = textSizes.footnote1,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    footnote2: TextStyle = TextStyle(
        fontSize = textSizes.footnote2,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    headline1: TextStyle = TextStyle(
        fontSize = textSizes.headline1,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    headline2: TextStyle = TextStyle(
        fontSize = textSizes.headline2,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    subtitle: TextStyle = TextStyle(
        fontSize = textSizes.subtitle,
        fontWeight = FontWeight.Bold,
        platformStyle = defaultPlatformTextStyle(),
    ),
    title1: TextStyle = TextStyle(
        fontSize = textSizes.title1,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    title2: TextStyle = TextStyle(
        fontSize = textSizes.title2,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    title3: TextStyle = TextStyle(
        fontSize = textSizes.title3,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
    title4: TextStyle = TextStyle(
        fontSize = textSizes.title4,
        fontWeight = FontWeight.Normal,
        platformStyle = defaultPlatformTextStyle(),
    ),
): TextStyles = TextStyles(
    main = main,
    body1 = body1,
    body2 = body2,
    paragraph = paragraph,
    button = button,
    footnote1 = footnote1,
    footnote2 = footnote2,
    headline1 = headline1,
    headline2 = headline2,
    subtitle = subtitle,
    title1 = title1,
    title2 = title2,
    title3 = title3,
    title4 = title4,
)

/** Default typography used when [MochiTheme] has no override. */
val DefaultTextStyles = defaultTextStyles()

internal expect fun defaultPlatformTextStyle(): PlatformTextStyle
