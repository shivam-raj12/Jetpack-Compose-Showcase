package com.shivam_raj.jetpackcomposeshowcase.text

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat

@Composable
fun MyAnnotatedText() {
    val text = stringResource(id = R.string.dummy_text)
    val size = text.length / 8

    BasicWidgetFormat(
        headline = "Annotated text"
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(Color.Green)) {
                    append(text.subSequence(0, size))
                }
                append(text.subSequence(size, 2 * size))

                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.ExtraBold
                    )
                ) {
                    append(text.subSequence(2 * size, 3 * size))
                }
                withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)) {
                    append(text.subSequence(3 * size, 4 * size))
                }
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(text.subSequence(4 * size, 5 * size))
                }
                withStyle(SpanStyle(background = Color.DarkGray, color = Color.White)) {
                    append(text.subSequence(5 * size, 6 * size))
                }
                withStyle(
                    SpanStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Gray
                    )
                ) {
                    append(text.subSequence(6 * size, 7 * size))
                }
                withStyle(SpanStyle(fontFamily = FontFamily.Cursive)) {
                    append(text.subSequence(7 * size, text.length))
                }
            },
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollingText() {
    val text = stringResource(id = R.string.dummy_text)
    BasicWidgetFormat(headline = "Scrolling text") {
        Text(text = text, modifier = Modifier.basicMarquee())
    }
}