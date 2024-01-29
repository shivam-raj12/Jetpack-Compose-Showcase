package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyFlowRow() {
    var itemCount by remember {
        mutableIntStateOf(1)
    }
    var vertical by remember {
        mutableStateOf(Arrangement.Top)
    }
    var horizontal by remember {
        mutableStateOf(Arrangement.Start)
    }
    BasicWidgetFormat(
        headline = "Flow row",
        content = {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .border(1.dp, Color.Black),
                verticalArrangement = vertical,
                horizontalArrangement = horizontal
            ) {
                repeat(itemCount) {
                    val color = Color(Random.nextLong(0xFFFFFFFF))
                    Text(
                        text = "Item ${it + 1}",
                        modifier = Modifier
                            .border(1.dp, color)
                            .padding(5.dp),
                        color = color,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        },
        outSideContent = {
            AddRemoveItem(itemCount = itemCount, onAddItemClick = { itemCount++ }) {
                itemCount--
            }
            FlowRow {
                FlowVerticalDropDown(
                    currentArrangement = vertical.toString(),
                    onVerticalSelected = { vertical = it })
                FlowHorizontalDropDown(
                    currentArrangement = horizontal.toString(),
                    onVerticalSelected = { horizontal = it }
                )
            }
        },
        boxHeight = 250.dp
    )
}