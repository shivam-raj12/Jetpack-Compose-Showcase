package com.shivam_raj.jetpackcomposeshowcase.navigationRail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.WidgetSpace
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun NavigationRailScreen(
    navigator: DestinationsNavigator
) {
    var showHeader by remember {
        mutableStateOf(true)
    }
    var showLabel by remember {
        mutableStateOf(true)
    }
    var alwaysShowLabel by remember {
        mutableStateOf(false)
    }
    var enabled by remember {
        mutableStateOf(true)
    }

    val iconAndTextList = remember {
        mapOf(
            Icons.Default.Add to "Add",
            Icons.Default.Build to "Build",
            Icons.Default.Edit to "Edit",
            Icons.Default.Call to "Call",
            Icons.Default.Delete to "Delete",
            Icons.Default.Info to "Info"
        )
    }

    var selected by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Navigation rail")
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier.padding(paddingValues)
        ) {
            NavigationRail(
                header = {
                    MyAnimatedVisibility(visible = showHeader) {
                        FloatingActionButton(onClick = { }) {
                            Icon(imageVector = Icons.Rounded.Create, contentDescription = null)
                        }
                    }
                }
            ) {
                iconAndTextList.onEachIndexed { index, entry ->
                    NavigationRailItem(
                        selected = index == selected,
                        onClick = { selected = index },
                        icon = {
                            Icon(
                                imageVector = entry.key,
                                contentDescription = null
                            )
                        },
                        label = {
                            if (showLabel){
                                Text(text = entry.value)
                            }
                        },
                        alwaysShowLabel = alwaysShowLabel,
                        enabled = enabled
                    )
                }
            }

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.navigation_rail),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 6.dp)
                )
                WidgetSpace()
                CheckboxWithText(
                    text = "Show header",
                    checked = showHeader,
                    onCheckedChange = { showHeader = it })
                CheckboxWithText(
                    text = "Show label",
                    checked = showLabel,
                    onCheckedChange = { showLabel = it })
                CheckboxWithText(
                    text = "Always show label",
                    checked = alwaysShowLabel,
                    onCheckedChange = { alwaysShowLabel = it })
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
            }
        }
    }
}