package com.shivam_raj.jetpackcomposeshowcase.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.DemoScreenButton
import com.shivam_raj.jetpackcomposeshowcase.destinations.LeadingIconTabDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ScrollableTabDemoDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.TabScreenDemoDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun TabsScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Tabs",
        description = R.string.tabs,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            {
                MyTabs {
                    navigator.navigate(TabScreenDemoDestination(it))
                }
            },
            {
                MyScrollableTabs {
                    navigator.navigate(ScrollableTabDemoDestination(it))
                }
            },
            {
                MyLeadingIconTab {
                    navigator.navigate(LeadingIconTabDemoDestination(it))
                }
            }
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTabs(onClick: (Boolean) -> Unit) {
    var index by remember {
        mutableIntStateOf(0)
    }
    val tabList = remember {
        List(3) {
            "Tab ${it + 1}"
        }
    }
    var icon by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Tabs",
        outSideContent = {
            CheckboxWithText(text = "Show icon", checked = icon, onCheckedChange = { icon = it })
            DemoScreenButton {
                onClick(icon)
            }
        }
    ) {
        PrimaryTabRow(selectedTabIndex = index) {
            tabList.forEachIndexed { currentIndex, s ->
                Tab(
                    selected = currentIndex == index,
                    onClick = { index = currentIndex },
                    text = {
                        Text(text = s)
                    },
                    icon = {
                        IconVisibility(visibility = icon)
                    }
                )
            }
        }
    }
}

@Composable
fun MyScrollableTabs(
    onClick: (Boolean) -> Unit
) {
    var index by remember {
        mutableIntStateOf(0)
    }
    val tabList = remember {
        List(10) {
            "Tab ${it + 1}"
        }
    }
    var icon by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Scrollable tabs",
        outSideContent = {
            CheckboxWithText(text = "Show icon", checked = icon, onCheckedChange = { icon = it })
            DemoScreenButton {
                onClick(icon)
            }
        }
    ) {
        ScrollableTabRow(selectedTabIndex = index) {
            tabList.forEachIndexed { currentIndex, s ->
                Tab(
                    selected = currentIndex == index,
                    onClick = { index = currentIndex },
                    text = {
                        Text(text = s)
                    },
                    icon = {
                        IconVisibility(visibility = icon)
                    }
                )
            }
        }
    }
}

@Composable
fun MyLeadingIconTab(
    onClick: (Boolean) -> Unit
) {
    var index by remember {
        mutableIntStateOf(0)
    }
    val tabList = remember {
        List(3) {
            "Tab ${it + 1}"
        }
    }
    var icon by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Leading icon tabs",
        outSideContent = {
            CheckboxWithText(text = "Show icon", checked = icon, onCheckedChange = { icon = it })
            DemoScreenButton(onClick = { onClick(icon) })
        }
    ) {
        TabRow(selectedTabIndex = index) {
            tabList.forEachIndexed { currentIndex, s ->
                LeadingIconTab(
                    selected = currentIndex == index,
                    onClick = { index = currentIndex },
                    text = {
                        Text(text = s)
                    },
                    icon = {
                        IconVisibility(visibility = icon)
                    }
                )
            }
        }
    }
}

@Composable
fun IconVisibility(
    visibility: Boolean
) {
    MyAnimatedVisibility(visibility) {
        Icon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = null
        )
    }
}