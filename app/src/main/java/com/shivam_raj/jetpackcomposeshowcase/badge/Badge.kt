package com.shivam_raj.jetpackcomposeshowcase.badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat

@Composable
fun MySmallBadge() {
    BasicWidgetFormat(headline = "Small badge") {
        BadgedBox(badge = {
            Badge(modifier = Modifier.size(6.dp))
        }) {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        }
    }
}

@Composable
fun MyLargeBadge() {
    var number by remember {
        mutableIntStateOf(47)
    }
    BasicWidgetFormat(
        headline = "Large badge",
        outSideContent = {
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                OutlinedIconButton(onClick = { number-- }) {
                    Text(text = "-1")
                }
                OutlinedIconButton(onClick = { number++ }) {
                    Text(text = "+1")
                }
            }
        }
    ) {
        BadgedBox(badge = {
            Badge {
                Text(text = number.toString())
            }
        }) {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        }
    }
}

@Composable
fun MyBadgeInNavigationItem() {
    var number by remember {
        mutableIntStateOf(74)
    }
    BasicWidgetFormat(
        headline = "Badge in navigation item",
        outSideContent = {
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                OutlinedIconButton(onClick = { number-- }) {
                    Text(text = "-1")
                }
                OutlinedIconButton(onClick = { number++ }) {
                    Text(text = "+1")
                }
            }
        },
        content = {
            NavigationDrawerItem(
                label = { Text(text = "Shopping cart") },
                selected = true,
                onClick = { },
                icon = {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null
                    )
                },
                badge = {
                    Badge {
                        Text(text = number.toString())
                    }
                }
            )
        }
    )
}

@Composable
fun MyBadgeInNavigationBar() {
    var selected by remember {
        mutableIntStateOf(0)
    }
    val textList = remember {
        listOf("Home", "Email", "Settings")
    }
    val iconList = remember {
        listOf(Icons.Default.Home, Icons.Default.Email, Icons.Default.Settings)
    }

    BasicWidgetFormat(
        headline = "Badge in bottom navigation",
        content = {
            NavigationBar {
                repeat(3) {
                    NavigationBarItem(
                        selected = selected == it,
                        onClick = { selected = it },
                        label = {
                            Text(text = textList[it])
                        },
                        icon = {
                            when(it){
                                0-> Icon(imageVector = iconList[0], contentDescription = null)
                                1-> BadgedBox(badge = {
                                    Badge{
                                        Text(text = "99")
                                    }
                                }) {
                                    Icon(imageVector = iconList[1], contentDescription = null)
                                }
                                else-> BadgedBox(badge = {
                                    Badge(modifier = Modifier.size(6.dp))
                                }) {
                                    Icon(imageVector = iconList[2], contentDescription = null)
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}