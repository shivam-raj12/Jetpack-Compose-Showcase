package com.shivam_raj.jetpackcomposeshowcase.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPlainToolTip() {
    BasicWidgetFormat(
        headline = "Plain tooltip",
        outSideContent = {
            Text(text = "Long press the icon to show tooltip")
        },
        content = {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = "This is a tooltip")
                    }
                },
                state = rememberTooltipState()
            ) {
                Icon(
                    imageVector = Icons.Default.Build, contentDescription = null
                )
            }
        }
    )
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyRichToolTip() {
    var showTitle by remember {
        mutableStateOf(false)
    }
    var showAction by remember {
        mutableStateOf(false)
    }
    val state = rememberTooltipState(isPersistent = showAction)
    BasicWidgetFormat(
        headline = "Rich tooltip",
        outSideContent = {
            Text(text = "Long press the icon to show tooltip")
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CheckboxWithText(
                    text = "Show title",
                    checked = showTitle,
                    onCheckedChange = { showTitle = it }
                )
                CheckboxWithText(
                    text = "Show action",
                    checked = showAction,
                    onCheckedChange = { showAction = it }
                )
            }
        },
        content = {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                tooltip = {
                    RichTooltip(
                        title = {
                            if (showTitle) {
                                Text(text = "Rich tooltip title")
                            }
                        },
                        text = {
                            Text(text = "Rich tooltip long detail text to define item uses")
                        },
                        action = {
                            if (showAction) {
                                TextButton(onClick = { state.dismiss() }) {
                                    Text(text = "Dismiss")
                                }
                            }
                        }
                    )
                },
                state = state
            ) {
                Icon(
                    imageVector = Icons.Default.Build, contentDescription = null
                )
            }
        }
    )
}