package com.shivam_raj.jetpackcomposeshowcase.chip

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ChipScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Chip",
        description = R.string.chip,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyAssistChip() },
            { MyElevatedAssistChip() },
            { MySuggestionChip() },
            { MyElevatedSuggestionChip() },
            { MyFilterChip() },
            { MyElevatedFilterChip() },
            { MyInputChip() }
        )
    )
}