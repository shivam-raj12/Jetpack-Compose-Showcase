package com.shivam_raj.jetpackcomposeshowcase.dialogBox

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun DialogBoxScreen(
    navigator: DestinationsNavigator
) {

    MyScaffold(title = "Dialog box",
        description = R.string.dialog_box,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf { DialogBox() }
    )
}


@Composable
fun DialogBox() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    var showDismissButton by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Dialog box",
        outSideContent = {
            CheckboxWithText(
                text = "Show icon",
                checked = showIcon,
                onCheckedChange = { showIcon = it })
            CheckboxWithText(
                text = "Show dismiss button",
                checked = showDismissButton,
                onCheckedChange = { showDismissButton = it })
        }
    ) {
        Button(onClick = { showDialog = !showDialog }) {
            Text(text = "Show dialog box")
        }
    }
    if (showDialog) {
        MyDialogBox(showIcon = showIcon, showDismissButton = showDismissButton) {
            showDialog = false
        }
    }
}

@Composable
fun MyDialogBox(
    showIcon: Boolean,
    showDismissButton: Boolean,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Dialog box")
        },
        text = {
            Text(text = "This is a dialog box")
        },
        dismissButton = {
            if (showDismissButton) {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "Close")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "Confirm")
            }
        },
        icon = {
            if (showIcon) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
        }
    )
}