package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
fun MyRow() {
    var vertical by remember {
        mutableStateOf(Alignment.Top)
    }
    var horizontal by remember {
        mutableStateOf(Arrangement.Start)
    }

    BasicWidgetFormat(
        headline = "Row layout",
        outSideContent = {
            FlowRow(horizontalArrangement = Arrangement.SpaceAround) {
                VerticalDropDown(
                    currentAlignment = when (vertical) {
                        Alignment.Top -> "Top"
                        Alignment.Bottom -> "Bottom"
                        else -> "CenterVertically"
                    },
                    onVerticalSelected = { vertical = it })
                HorizontalDropDown(
                    currentArrangement = horizontal.toString(),
                    onVerticalSelected = { horizontal = it }
                )
            }
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, Color.Black),
            verticalAlignment = vertical,
            horizontalArrangement = horizontal
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
    currentAlignment: String,
    onVerticalSelected: (Alignment.Vertical) -> Unit
) {
    val alignmentList = remember {
        listOf(
            "Top",
            "CenterVertically",
            "Bottom"
        )
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Vertical alignment:-")
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
                        .replace("Arrangement#", "")
                )
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                alignmentList.forEach {
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

private fun getVertical(s: String): Alignment.Vertical {
    return when (s) {
        "Top" -> Alignment.Top
        "Bottom" -> Alignment.Bottom
        else -> Alignment.CenterVertically
    }
}

@Composable
private fun HorizontalDropDown(
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
                        onClick = { onVerticalSelected(getHorizontal(it));isExpanded = false })
                }
            }
        }
    }
}

private fun getHorizontal(s: String): Arrangement.Horizontal {
    return when (s) {
        "Start" -> Arrangement.Start
        "End" -> Arrangement.End
        "SpaceAround" -> Arrangement.SpaceAround
        "SpaceEvenly" -> Arrangement.SpaceEvenly
        "SpaceBetween" -> Arrangement.SpaceBetween
        else -> Arrangement.Center
    }
}