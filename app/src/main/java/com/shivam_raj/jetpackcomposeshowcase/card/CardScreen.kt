package com.shivam_raj.jetpackcomposeshowcase.card

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun CardScreen(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator
) {
    MyScaffold(
        title = "Card",
        description = R.string.card,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { SimpleCard()},
            { MyElevatedCard()},
            { MyOutlinedCard()},
        )
    )
}