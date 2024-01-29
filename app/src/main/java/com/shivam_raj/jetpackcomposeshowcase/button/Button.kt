package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

@Composable
fun Button() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Button",
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
        Button(
            onClick = { },
            enabled = enabled
        ) {
            AnimatedVisibility(showIcon) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Text(text = "Button")
        }
    }
}

@Composable
fun FilledTonalButton() {
    var showIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Filled tonal button",
        outSideContent = {
            CheckboxWithText(
                text = "Show icon",
                checked = showIcon,
                onCheckedChange = { showIcon = it })
        }
    ) {
        FilledTonalButton(onClick = { }) {
            AnimatedVisibility(showIcon) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            Text(text = "Filled tonal button")
        }
    }
}

@Composable
fun TextButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Text button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        TextButton(onClick = { }, enabled = enabled) {
            Text(text = "Text button")
        }
    }
}

