package com.shivam_raj.jetpackcomposeshowcase.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat


@Composable
fun SubScriptText() {
    BasicWidgetFormat(
        headline = "Subscript text"
    ) {
        Text(
            buildAnnotatedString {
                append("C")
                withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)) {
                    append("6")
                }
                append("H")
                withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)) {
                    append("12")
                }
                append("O")
                withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)) {
                    append("6")
                }
            },
            style = MaterialTheme.typography.headlineSmall
        )
    }
}