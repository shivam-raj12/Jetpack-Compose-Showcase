package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.topAppBarDemo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun CenterTopAppBarDemo(
    navigator: DestinationsNavigator
) {
    var selected by remember {
        mutableIntStateOf(0)
    }
    val state = when (selected) {
        0 -> TopAppBarDefaults.pinnedScrollBehavior()
        1 -> TopAppBarDefaults.enterAlwaysScrollBehavior()
        else -> TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    }
    Scaffold(
        modifier = Modifier.nestedScroll(state.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Center app bar demo")
                },
                actions = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close demo")
                    }
                },
                scrollBehavior = state
            )
        }
    ) { paddingValues ->
        ScrollItems(
            paddingValues = paddingValues,
            selected = selected,
            onSelectedChange = {
                selected = it
            }
        )
    }
}