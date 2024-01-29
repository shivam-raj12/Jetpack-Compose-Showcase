package com.shivam_raj.jetpackcomposeshowcase.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
@Preview
fun TextScreen(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator
) {
    MyScaffold(
        title = "Text",
        description = R.string.text,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { SimpleText() },
            { MyAnnotatedText() },
            { SuperScriptText() },
            { SubScriptText() },
            { ScrollingText() },
            { MyLinearGradientText() },
            { MyRadialGradientText() }
        )
    )
}