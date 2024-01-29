package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.bottomBarScreenDemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility
import com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.CenterAlignedScaffold
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun BottomAppBarDemo(
    navigator: DestinationsNavigator,
    showFloating: Boolean
) {
    val iconList = remember {
        listOf(Icons.Default.Menu, Icons.Default.Create, Icons.Default.Search, Icons.Default.Delete)
    }
    CenterAlignedScaffold(
        title = "Bottom app bar demo",
        onCrossClick = { navigator.popBackStack() }) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                actions = {
                    iconList.forEach {
                        IconButton(onClick = { }) {
                            Icon(imageVector = it, contentDescription = null)
                        }
                    }
                },
                floatingActionButton = {
                    MyAnimatedVisibility(visible = showFloating) {
                        FloatingActionButton(onClick = { }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    }
                },
                tonalElevation = 13.dp
            )
        }
    }
}