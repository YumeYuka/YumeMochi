/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

/** Immutable snapshot of all tokens consumed by [MochiTheme]. */
@Immutable
data class ThemeState(
    /** Whether the current theme uses dark colors. */
    val dark: Boolean,
    /** Active color tokens for Yume UI components. */
    val colors: Colors,
    /** Active semantic status colors. */
    val extraColors: ExtraColors,
    /** Active text style tokens for Yume UI components. */
    val textStyles: TextStyles,
    /** Active spacing tokens for Yume UI layouts and components. */
    val spacing: Spacing,
    /** Active scalar tokens for proportional values. */
    val scale: Scale,
)

/**
 * Read-only access point for YumeMochi theme values inside composables.
 */
object MochiTheme {
    /** Active color tokens. */
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.colors

    /** Active semantic status colors. */
    val extraColors: ExtraColors
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.extraColors

    /** Active text style tokens. */
    val textStyles: TextStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.textStyles

    /** Active spacing tokens. */
    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.spacing

    /** Active scalar tokens. */
    val scale: Scale
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.scale

    /** Whether the current theme uses dark colors. */
    val dark: Boolean
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeState.current.dark
}

/**
 * Provides YumeMochi design tokens to [content].
 *
 * The remaining token groups may be overridden independently.
 *
 * @param dark Whether the supplied palette represents dark mode. Defaults to the system setting.
 * @param colors Primary semantic colors used by all YumeMochi components.
 * @param spacing Standard layout spacing values.
 * @param scale Ratios used to derive token values, such as paragraph line height.
 * @param textStyles Typography tokens used by text components.
 * @param content Descendant UI receiving the theme through composition locals.
 */
@Composable
fun MochiTheme(
    dark: Boolean = isSystemInDarkTheme(),
    colors: Colors = platformColors(dark),
    extraColors: ExtraColors = defaultExtraColors(dark),
    spacing: Spacing = DefaultSpacing,
    scale: Scale = DefaultScale,
    textStyles: TextStyles = defaultTextStyles(scale = scale),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemeState provides ThemeState(
            dark = dark,
            colors = colors,
            extraColors = extraColors,
            textStyles = textStyles,
            spacing = spacing,
            scale = scale,
        ),
        LocalTextStyles provides textStyles,
        content = content,
    )
}

/** Internal composition-local storage backing [MochiTheme]. */
internal val LocalThemeState = staticCompositionLocalOf {
    ThemeState(
        dark = false,
        colors = lightColors(),
        extraColors = lightExtraColors(),
        textStyles = DefaultTextStyles,
        spacing = DefaultSpacing,
        scale = DefaultScale,
    )
}

/**
 * Resolves the default text styles provided by [MochiTheme].
 */
val LocalTextStyles = staticCompositionLocalOf { DefaultTextStyles }

/**
 * Returns platform-specific color tokens.
 */
@Composable
internal expect fun platformColors(
    dark: Boolean,
): Colors
