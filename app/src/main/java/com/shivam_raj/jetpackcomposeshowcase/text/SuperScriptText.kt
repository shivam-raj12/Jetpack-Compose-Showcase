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
fun SuperScriptText() {
    BasicWidgetFormat(
        headline = "Superscript text"
    ) {
        Text(
            buildAnnotatedString {
                append("a")
                withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                    append("2")
                }
                append(" + b")
                withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                    append("2")
                }
                append(" = c")
                withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                    append("2")
                }
            },
            style = MaterialTheme.typography.headlineSmall
        )
    }
}