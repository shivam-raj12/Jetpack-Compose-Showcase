package com.shivam_raj.jetpackcomposeshowcase.basicComponent

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun BasicWidgetFormat(
    headline: String,
    boxHeight: Dp = 70.dp,
    paddingValues: PaddingValues = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
    outSideContent: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Text(
        text = headline,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 8.dp)
    )
    Column(
        Modifier
            .padding(start = 8.dp, end = 8.dp, top = 5.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = boxHeight)
                .wrapContentHeight(align = Alignment.CenterVertically, true)
                .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.medium)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
        if (outSideContent != null) {
            outSideContent()
        }
        WidgetSpace()
    }
}