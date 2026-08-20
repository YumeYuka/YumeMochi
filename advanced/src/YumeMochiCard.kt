/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.advanced

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.yumeyuka.yumemochi.basic.yumeMochiSurface
import moe.yumeyuka.yumemochi.theme.MochiTheme

/**
 * A simple elevated-content container with the library's standard squircle surface.
 *
 * @param title Primary card label.
 * @param description Supporting text below [title].
 * @param modifier Modifier applied to the outer card container.
 */
@Composable
public fun YumeMochiCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    val colors = MochiTheme.colors

    Column(modifier = modifier.yumeMochiSurface().padding(16.dp)) {
        BasicText(
            text = title,
            style =
                TextStyle(
                    color = colors.text1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
        )
        BasicText(
            text = description,
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
            style = TextStyle(color = colors.text2, fontSize = 14.sp),
        )
    }
}
