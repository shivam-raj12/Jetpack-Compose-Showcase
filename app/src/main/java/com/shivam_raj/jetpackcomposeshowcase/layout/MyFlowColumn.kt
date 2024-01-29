package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyFlowColumn() {
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
        headline = "Flow column",
        content = {
            FlowColumn(
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

@Composable
fun AddRemoveItem(
    itemCount: Int,
    onAddItemClick: () -> Unit,
    onRemoveItemClick: () -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(onClick = onAddItemClick, enabled = itemCount != 20) {
            Text(text = "Add item")
        }
        OutlinedButton(onClick = onRemoveItemClick, enabled = itemCount != 1) {
            Text(text = "Remove item")
        }
    }
}

@Composable
fun FlowVerticalDropDown(
    currentArrangement: String,
    onVerticalSelected: (Arrangement.Vertical) -> Unit
) {
    val arrangementList = remember {
        listOf(
            "Top",
            "Center",
            "Bottom",
            "SpaceAround",
            "SpaceBetween",
            "SpaceEvenly"
        )
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Vertical arrangement:-")
        Spacer(modifier = Modifier.width(5.dp))
        Box {
            OutlinedButton(
                onClick = { isExpanded = !isExpanded },
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    ButtonDefaults.outlinedButtonBorder.width,
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = currentArrangement
                        .replace("Arrangement#", "")
                )
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                arrangementList.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = it
                            )
                        },
                        onClick = { onVerticalSelected(flowGetVertical(it));isExpanded = false })
                }
            }
        }
    }
}

fun flowGetVertical(s: String): Arrangement.Vertical {
    return when (s) {
        "Top" -> Arrangement.Top
        "Bottom" -> Arrangement.Bottom
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        "SpaceBetween" -> Arrangement.SpaceBetween
        else -> Arrangement.Center
    }
}


@Composable
fun FlowHorizontalDropDown(
    currentArrangement: String,
    onVerticalSelected: (Arrangement.Horizontal) -> Unit
) {
    val arrangementList = remember {
        listOf(
            "Start",
            "Center",
            "End",
            "SpaceAround",
            "SpaceBetween",
            "SpaceEvenly"
        )
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Horizontal arrangement:-")
        Spacer(modifier = Modifier.width(5.dp))
        Box {
            OutlinedButton(
                onClick = { isExpanded = !isExpanded },
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    ButtonDefaults.outlinedButtonBorder.width,
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = currentArrangement
                        .replace("Arrangement#", "")
                )
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                arrangementList.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = it
                            )
                        },
                        onClick = { onVerticalSelected(flowGetHorizontal(it));isExpanded = false })
                }
            }
        }
    }
}

private fun flowGetHorizontal(s: String): Arrangement.Horizontal {
    return when (s) {
        "Start" -> Arrangement.Start
        "End" -> Arrangement.End
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        "SpaceBetween" -> Arrangement.SpaceBetween
        else -> Arrangement.Center
    }
}