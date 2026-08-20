package moe.yumeyuka.yumemochi.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle

@Composable
internal actual fun platformColors(dark: Boolean): Colors = if (dark) darkColors() else lightColors()

internal actual fun defaultPlatformTextStyle(): PlatformTextStyle = PlatformTextStyle(
    spanStyle = null,
    paragraphStyle = null,
)
