package com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySmallTopAppBar(
    onClick: () -> Unit
) {
    BasicWidgetFormat(headline = "Top app bar",
        outSideContent = {
            DemoScreenButton(onClick = onClick)
        }) {
        TopAppBar(
            title = {
                Text(text = "App bar title")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            },
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCenterTopAppBar(
    onClick: () -> Unit
) {
    BasicWidgetFormat(headline = "Center aligned top app bar",
        outSideContent = { DemoScreenButton(onClick = onClick) }) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "App bar title")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMediumTopAppBar(
    onClick: () -> Unit
) {
    BasicWidgetFormat(
        headline = "Medium top app bar",
        outSideContent = { DemoScreenButton(onClick = onClick) }) {
        MediumTopAppBar(
            title = {
                Text(text = "App bar title")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLargeTopAppBar(
    onClick: () -> Unit
) {
    BasicWidgetFormat(
        headline = "Large top app bar",
        outSideContent = { DemoScreenButton(onClick = onClick) }) {
        LargeTopAppBar(
            title = {
                Text(text = "App bar title")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@Composable
fun DemoScreenButton(
    onClick: () -> Unit={}
) {
    ElevatedButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth(),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 5.dp,
            pressedElevation = 7.dp
        )
    ) {
        Text(text = "Full screen demo")
    }
}