package com.shivam_raj.jetpackcomposeshowcase.badge

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun BadgeScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Badge",
        description = R.string.badge,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MySmallBadge()},
            { MyLargeBadge()},
            { MyBadgeInNavigationItem()},
            { MyBadgeInNavigationBar()}
        )
    )
}