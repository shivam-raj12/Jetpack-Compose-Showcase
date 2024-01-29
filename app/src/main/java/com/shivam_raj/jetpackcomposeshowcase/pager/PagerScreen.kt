package com.shivam_raj.jetpackcomposeshowcase.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PagerScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Pager",
        description = R.string.pager,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyHorizontalPager() },
            { MyVerticalPager() }
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyHorizontalPager() {
    val state = rememberPagerState {
        4
    }
    BasicWidgetFormat(headline = "Horizontal pager", outSideContent = {
        Text(text = "Scroll page horizontally")
    }) {
        HorizontalPager(
            state = state,
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            AsyncImage(
                model = when (it) {
                    0 -> R.drawable.p1
                    1 -> R.drawable.p2
                    2 -> R.drawable.p3
                    else -> R.drawable.p4
                },
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyVerticalPager() {
    val state = rememberPagerState {
        4
    }
    BasicWidgetFormat(headline = "Vertical pager", outSideContent = {
        Text(text = "Scroll page vertically")
    }) {
        VerticalPager(
            state = state,
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            AsyncImage(
                model = when (it) {
                    0 -> R.drawable.p1
                    1 -> R.drawable.p2
                    2 -> R.drawable.p3
                    else -> R.drawable.p4
                },
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}