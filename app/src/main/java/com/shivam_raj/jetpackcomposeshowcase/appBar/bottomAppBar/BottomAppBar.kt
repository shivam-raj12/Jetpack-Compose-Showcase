package com.shivam_raj.jetpackcomposeshowcase.appBar.bottomAppBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility
import com.shivam_raj.jetpackcomposeshowcase.appBar.topAppBar.DemoScreenButton

@Composable
fun MyBottomAppBar(
    onClick: (Boolean) -> Unit
) {
    val iconList = remember {
        listOf(Icons.Default.Menu, Icons.Default.Create, Icons.Default.Search, Icons.Default.Delete)
    }
    var showFloating by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(headline = "Bottom app bar", outSideContent = {
        Column {
            CheckboxWithText(
                text = "Show floating action button",
                checked = showFloating,
                onCheckedChange = { showFloating = it }
            )
            DemoScreenButton(onClick = { onClick(showFloating) })
        }
    }) {
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyBottomNavigation(
    onClick: (Boolean, Int) -> Unit
) {
    var enabled by remember {
        mutableStateOf(true)
    }
    var selected by remember {
        mutableIntStateOf(1)
    }
    var alwaysShowLabel by remember {
        mutableStateOf(true)
    }
    var itemCount by remember {
        mutableIntStateOf(3)
    }
    val list = remember {
        listOf(
            Icons.Default.Home,
            Icons.Default.Search,
            Icons.Default.Share,
            Icons.Default.Notifications,
            Icons.Default.Info
        )
    }
    BasicWidgetFormat(headline = "Bottom navigation", outSideContent = {
        FlowRow(horizontalArrangement = Arrangement.SpaceAround) {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
            CheckboxWithText(
                text = "Always show label",
                checked = alwaysShowLabel,
                onCheckedChange = { alwaysShowLabel = it })
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
                OutlinedButton(onClick = { itemCount-- }, enabled = itemCount != 3) {
                    Text(text = "Remove item")
                }
                OutlinedButton(onClick = { itemCount++ }, enabled = itemCount != 5) {
                    Text(text = "Add item")
                }
            }
        }
        DemoScreenButton(onClick = {onClick(alwaysShowLabel, itemCount)})
    }) {
        NavigationBar(modifier = Modifier.fillMaxWidth()) {
            for (x in 1..itemCount) {
                NavigationBarItem(
                    selected = x == selected,
                    enabled = enabled,
                    onClick = { selected = x },
                    alwaysShowLabel = alwaysShowLabel,
                    icon = {
                        Icon(imageVector = list[x - 1], contentDescription = null)
                    },
                    label = {
                        Text(text = "Item $x")
                    }
                )
            }
        }
    }
}