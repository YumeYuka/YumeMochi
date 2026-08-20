package moe.yumeyuka.yumemochi.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.yumeyuka.yumemochi.advanced.YumeMochiCard
import moe.yumeyuka.yumemochi.theme.MochiIcon
import moe.yumeyuka.yumemochi.theme.MochiTheme
import io.github.yumeyucca.lucide.Lucide

private data class ExampleItem(
    val title: String,
    val description: String,
)

@Composable
public fun ExampleApp() {
    MochiTheme {
        val colors = MochiTheme.colors
        val items = listOf(
            ExampleItem("Theme", "Shared colors and composition locals."),
            ExampleItem("Base", "Basic reusable UI building blocks."),
            ExampleItem("Advanced", "Higher-level reusable UI components."),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.bg)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            BasicText(
                text = "YumeMochi Example",
                style = TextStyle(
                    color = colors.text1,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                ),
            )
            MochiIcon(
                imageVector = Lucide.Info,
                contentDescription = null,
                size = MochiTheme.iconSize.lg,
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(items, key = ExampleItem::title) { item ->
                    YumeMochiCard(
                        title = item.title,
                        description = item.description,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}
