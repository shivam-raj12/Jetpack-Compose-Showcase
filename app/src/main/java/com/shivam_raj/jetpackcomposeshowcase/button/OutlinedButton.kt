package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.state.ToggleableState
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

@Composable
fun MyOutlineButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Outlined button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
            CheckboxWithText(
                text = "Show icon",
                checked = showIcon,
                onCheckedChange = { showIcon = it })
        }
    ) {
        OutlinedButton(onClick = {  }, enabled = enabled) {
            AnimatedVisibility(showIcon) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Text(text = "Outlined button")
        }
    }
}

@Composable
fun MyCheckBox() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(false)
    }

    BasicWidgetFormat(
        headline = "Checkbox",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Checkbox(checked = checked, onCheckedChange = { checked = it }, enabled = enabled)
    }
}

@Composable
fun MyTriStateCheckBox() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var state by remember {
        mutableStateOf(ToggleableState.On)
    }

    BasicWidgetFormat(
        headline = "Tri state checkbox",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        TriStateCheckbox(state = state, onClick = {
            state = when (state) {
                ToggleableState.On -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.Off
                else -> ToggleableState.On
            }
        }, enabled = enabled)
    }
}

@Composable
fun MyRadioButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableIntStateOf(0)
    }

    BasicWidgetFormat(
        headline = "Radio button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Row {
            repeat(3) {
                RadioButton(selected = it == checked, onClick = { checked = it }, enabled = enabled)
            }
        }
    }
}

@Composable
fun MySwitch() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(false)
    }

    BasicWidgetFormat(
        headline = "Switch",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Switch(checked = checked, onCheckedChange = { checked = it }, enabled = enabled)
    }
}