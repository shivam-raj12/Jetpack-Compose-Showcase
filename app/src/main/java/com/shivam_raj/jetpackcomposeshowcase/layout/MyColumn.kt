package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun MyColumn() {
    var vertical by remember {
        mutableStateOf(Arrangement.Top)
    }
    var horizontal by remember {
        mutableStateOf(Alignment.Start)
    }
    BasicWidgetFormat(
        headline = "Column layout",
        outSideContent = {
            FlowRow(horizontalArrangement = Arrangement.SpaceAround) {
                HorizontalDropDown(
                    currentAlignment = when (horizontal) {
                        Alignment.End -> "End"
                        Alignment.Start -> "Start"
                        else -> "CenterHorizontally"
                    },
                    onHorizontalSelected = { horizontal = it }
                )
                VerticalDropDown(
                    currentArrangement = vertical.toString(),
                    onVerticalSelected = { vertical = it }
                )
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, Color.Black)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = vertical,
            horizontalAlignment = horizontal
        ) {
            repeat(3) {
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
    }
}

@Composable
private fun VerticalDropDown(
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
                        onClick = { onVerticalSelected(getVertical(it));isExpanded = false })
                }
            }
        }
    }
}

private fun getVertical(s: String): Arrangement.Vertical {
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
private fun HorizontalDropDown(
    currentAlignment: String,
    onHorizontalSelected: (Alignment.Horizontal) -> Unit
) {
    val alignmentList = remember {
        listOf("Start", "CenterHorizontally", "End")
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Horizontal alignment:-")
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
                    text = currentAlignment
                )
            }
            DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                alignmentList.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = it
                            )
                        },
                        onClick = { onHorizontalSelected(getHorizontal(it));isExpanded = false })
                }
            }
        }
    }
}

private fun getHorizontal(it: String): Alignment.Horizontal {
    return when (it) {
        "Start" -> Alignment.Start
        "End" -> Alignment.End
        else -> Alignment.CenterHorizontally
    }
}
