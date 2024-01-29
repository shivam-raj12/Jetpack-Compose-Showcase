package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun LayoutScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Layouts",
        description = R.string.layouts,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyColumn() },
            { MyRow() },
            { MyBox() },
            { MyFlowRow() },
            { MyFlowColumn() },
        )
    )
}