package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

@Composable
fun IconButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Icon button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        IconButton(onClick = { }, enabled = enabled) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
        }
    }
}

@Composable
fun FilledIconButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Filled icon button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        FilledIconButton(onClick = { }, enabled = enabled) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
        }
    }
}

@Composable
fun IconToggleButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Icon toggle button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = enabled
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        }
    }
}

@Composable
fun FilledIconToggleButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Filled icon toggle button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        FilledIconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = enabled
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        }
    }
}

@Composable
fun FilledTonalIconButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Filled tonal icon button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        FilledTonalIconButton(onClick = { }, enabled = enabled) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
        }
    }
}

@Composable
fun OutlinedIconToggleButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Outlined icon toggle button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        OutlinedIconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = enabled
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        }
    }
}

@Composable
fun OutlinedIconButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Outlined icon button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        OutlinedIconButton(onClick = { }, enabled = enabled) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
        }
    }
}

@Composable
fun FilledTonalIconToggleButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var checked by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Filled tonal icon toggle button",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        FilledTonalIconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = enabled
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        }
    }
}