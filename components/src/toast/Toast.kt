/*
 * Copyright (c) 2026 YumeYuka
 *
 * SPDX-License-Identifier: BSD 3-Clause License
 */

package moe.yumeyuka.yumemochi.components.toast

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import moe.yumeyuka.yumemochi.theme.MochiTheme
import top.yukonga.miuix.kmp.squircle.squircleBackground

@Composable
fun Toast(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    style: ToastStyle = ToastDefaults.default(),
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 64.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = ToastShape,
                    clip = false,
                    ambientColor = Color(0x1F000000),
                    spotColor = Color(0x26000000),
                )
                .squircleBackground(
                    color = style.containerColor,
                    cornerRadius = 24.dp,
                )
                .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberVectorPainter(style.icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            colorFilter = ColorFilter.tint(style.iconColor),
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            BasicText(
                text = title,
                style =
                    MochiTheme.textStyles.body1.copy(
                        color = style.titleColor,
                        fontWeight = FontWeight.SemiBold,
                    ),
            )
            description?.let {
                BasicText(
                    text = it,
                    style = MochiTheme.textStyles.body2.copy(color = style.contentColor),
                )
            }
        }
    }
}

private val ToastShape = RoundedCornerShape(24.dp)
