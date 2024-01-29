package com.shivam_raj.jetpackcomposeshowcase.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.ui.theme.Gradient1
import com.shivam_raj.jetpackcomposeshowcase.ui.theme.Gradient2

@Composable
fun MyLinearGradientText() {
    BasicWidgetFormat(
        headline = "Linear gradient text"
    ) {
        Text(
            text = stringResource(id = R.string.dummy_text),
            style = MaterialTheme.typography.headlineSmall.copy(
                brush = Brush.linearGradient(
                    listOf(Gradient1, Gradient2)
                )
            ),
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun MyRadialGradientText() {
    BasicWidgetFormat(
        headline = "Radial gradient text"
    ) {
        Text(
            text = stringResource(id = R.string.dummy_text),
            style = MaterialTheme.typography.headlineSmall.copy(
                brush = Brush.radialGradient(
                    listOf(Gradient1, Gradient2)
                )
            ),
            fontStyle = FontStyle.Normal
        )
    }
}