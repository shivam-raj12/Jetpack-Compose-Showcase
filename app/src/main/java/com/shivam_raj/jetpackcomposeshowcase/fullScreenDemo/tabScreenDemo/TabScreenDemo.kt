package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.tabScreenDemo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.CenterAlignedScaffold
import com.shivam_raj.jetpackcomposeshowcase.tabs.IconVisibility
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Destination
fun TabScreenDemo(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator,
    state: Boolean
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        3
    }
    val c = rememberCoroutineScope()
    CenterAlignedScaffold(title = "Tab demo", onCrossClick = { navigator.popBackStack() }) {
        Column(Modifier.padding(it)) {
            TabRow(selectedTabIndex = pagerState.currentPage) {
                repeat(3) { index ->
                    Tab(selected = index == pagerState.currentPage, onClick = {
                        c.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                        text = {
                            Text(text = "Item ${index + 1}")
                        },
                        icon = {
                            IconVisibility(visibility = state)
                        }
                    )
                }
            }
            HorizontalPager(state = pagerState) { pageNumber ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(
                                        Random.nextLong(
                                            0xFFFFFFFF
                                        )
                                    ), Color(Random.nextLong(0xFFFFFFFF))
                                )
                            )
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Page ${pageNumber + 1}",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}