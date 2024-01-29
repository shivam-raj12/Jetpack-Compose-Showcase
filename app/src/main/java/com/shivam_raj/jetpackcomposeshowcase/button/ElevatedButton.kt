package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.DropDownSelector
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.DropDownSelectorItem

@Composable
fun ElevatedButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    val list = remember {
        listOf(1.dp, 3.dp, 5.dp, 7.dp, 9.dp, 11.dp, 13.dp, 15.dp)
    }
    var selected by remember {
        mutableStateOf(1.dp)
    }
    BasicWidgetFormat(
        headline = "Elevated button",
        outSideContent = {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })

                CheckboxWithText(
                    text = "Show icon",
                    checked = showIcon,
                    onCheckedChange = { showIcon = it })
            }

            DropDownSelector(
                dropDownSelectorItem = DropDownSelectorItem(
                    title = "Elevation",
                    itemList = list,
                    selected = selected,
                    onClick = { selected = it as Dp })
            )
        }
    ) {
        ElevatedButton(
            onClick = { },
            enabled = enabled,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = selected,
                disabledElevation = selected
            )
        ) {
            AnimatedVisibility(showIcon) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Text(text = "Elevated button")
        }
    }
}