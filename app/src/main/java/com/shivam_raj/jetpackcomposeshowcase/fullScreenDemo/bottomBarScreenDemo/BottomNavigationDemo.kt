package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.bottomBarScreenDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

import com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.CenterAlignedScaffold
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.random.Random

@Composable
@Destination
fun BottomNavigationDemo(
    navigator: DestinationsNavigator,
    showLabel: Boolean,
    itemCount: Int
) {
    val list = remember {
        listOf(
            Icons.Default.Home,
            Icons.Default.Search,
            Icons.Default.Share,
            Icons.Default.Notifications,
            Icons.Default.Info
        )
    }
    var selected by remember {
        mutableIntStateOf(1)
    }
    CenterAlignedScaffold(
        title = "Bottom navigation demo",
        onCrossClick = { navigator.popBackStack() }) {
        Column {
            val color = Color(Random.nextLong(0xFFFFFFFF))
            val textColor = if (color.luminance()*color.alpha>0.5) Color.White else Color.Black
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Text(text = list[selected-1].name.replace("Filled.", ""), style = MaterialTheme.typography.displaySmall, color = textColor)
            }
            NavigationBar {
                for (x in 1..itemCount) {
                    NavigationBarItem(
                        selected = x == selected,
                        onClick = { selected = x },
                        alwaysShowLabel = showLabel,
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
}