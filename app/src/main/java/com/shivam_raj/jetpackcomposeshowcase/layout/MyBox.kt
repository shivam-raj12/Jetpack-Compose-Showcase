package com.shivam_raj.jetpackcomposeshowcase.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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

@Composable
fun MyBox() {
    var alignment by remember {
        mutableStateOf(Alignment.TopCenter)
    }
    BasicWidgetFormat(
        headline = "Box layout",
        outSideContent = {
            AlignmentDropDown(
                currentAlignment = when (alignment) {
                    Alignment.TopStart -> "TopStart"
                    Alignment.TopCenter -> "TopCenter"
                    Alignment.TopEnd -> "TopEnd"
                    Alignment.CenterStart -> "CenterStart"
                    Alignment.Center -> "Center"
                    Alignment.CenterEnd -> "CenterEnd"
                    Alignment.BottomStart -> "BottomStart"
                    Alignment.BottomCenter -> "BottomCenter"
                    else -> "BottomEnd"
                },
                onVerticalSelected = { alignment = it })
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, Color.Black),
            contentAlignment = alignment
        ) {
            Text(
                text = "Item",
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    .padding(5.dp),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
private fun AlignmentDropDown(
    currentAlignment: String,
    onVerticalSelected: (Alignment) -> Unit
) {
    val alignmentList = remember {
        listOf(
            "TopStart",
            "TopCenter",
            "TopEnd",
            "CenterStart",
            "Center",
            "CenterEnd",
            "BottomStart",
            "BottomCenter",
            "BottomEnd"
        )
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Content alignment:-")
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
                        onClick = { onVerticalSelected(getAlignment(it));isExpanded = false })
                }
            }
        }
    }
}

private fun getAlignment(s: String): Alignment {
    return when (s) {
        "TopStart" -> Alignment.TopStart
        "TopCenter" -> Alignment.TopCenter
        "TopEnd" -> Alignment.TopEnd
        "CenterStart" -> Alignment.CenterStart
        "Center" -> Alignment.Center
        "CenterEnd" -> Alignment.CenterEnd
        "BottomStart" -> Alignment.BottomStart
        "BottomCenter" -> Alignment.BottomCenter
        else -> Alignment.BottomEnd
    }
}