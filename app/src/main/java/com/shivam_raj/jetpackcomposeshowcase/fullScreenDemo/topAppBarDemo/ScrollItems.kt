package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo.topAppBarDemo

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ScrollItems(
    paddingValues: PaddingValues,
    selected: Int,
    onSelectedChange: (Int) -> Unit
) {
    val list = remember {
        listOf(
            "pinnedScrollBehavior",
            "enterAlwaysScrollBehavior",
            "exitUntilCollapsedScrollBehavior"
        )
    }
    Column(Modifier.padding(paddingValues)) {
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(3) {
                FilterChip(
                    selected = selected == it,
                    onClick = { onSelectedChange(it) },
                    label = {
                        Text(text = list[it])
                    }
                )
            }
        }
        LazyColumn {
            items(40) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(15.dp), contentAlignment = Alignment.Center
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(72.dp)
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    MaterialTheme.colorScheme.primaryContainer,
                                    shape = CircleShape
                                ),

                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${index+1}",
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(Modifier.weight(1f)) {
                            Text(
                                text = "Headline",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Supporting text",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                }
            }
        }
    }
}

