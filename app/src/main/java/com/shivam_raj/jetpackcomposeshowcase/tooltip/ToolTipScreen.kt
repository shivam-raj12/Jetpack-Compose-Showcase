package com.shivam_raj.jetpackcomposeshowcase.tooltip

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ToolTipScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Tooltip",
        description = R.string.tooltip,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyPlainToolTip()},
            { MyRichToolTip()}
        )
    )
}