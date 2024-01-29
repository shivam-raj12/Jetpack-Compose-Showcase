package com.shivam_raj.jetpackcomposeshowcase.appBar

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.appBar.bottomAppBar.MyBottomAppBar
import com.shivam_raj.jetpackcomposeshowcase.appBar.bottomAppBar.MyBottomNavigation
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.MyCenterTopAppBar
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.MyLargeTopAppBar
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.MyMediumTopAppBar
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.MySmallTopAppBar
import com.shivam_raj.jetpackcomposeshowcase.destinations.BottomAppBarDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.BottomNavigationDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.CenterTopAppBarDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.LargeTopAppBarDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.MediumTopAppBarDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.SmallTopAppBarDemoDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun AppBarScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "App bars",
        description = R.string.app_bar,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            {
                MyBottomAppBar {
                    navigator.navigate(BottomAppBarDemoDestination(it))
                }
            },
            {
                MyBottomNavigation {showLabel, count ->
                    navigator.navigate(BottomNavigationDemoDestination(showLabel, count))
                }
            },
            {
                MySmallTopAppBar {
                    navigator.navigate(SmallTopAppBarDemoDestination)
                }
            },
            {
                MyCenterTopAppBar {
                    navigator.navigate(CenterTopAppBarDemoDestination)
                }
            },
            {
                MyMediumTopAppBar {
                    navigator.navigate(MediumTopAppBarDemoDestination)
                }
            },
            {
                MyLargeTopAppBar {
                    navigator.navigate(LargeTopAppBarDemoDestination)
                }
            }
        )
    )
}