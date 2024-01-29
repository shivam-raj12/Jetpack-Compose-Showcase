package com.shivam_raj.jetpackcomposeshowcase.chip

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyAssistChip() {
    var enabled by remember {
        mutableStateOf(true)
    }

    var showLeadingIcon by remember {
        mutableStateOf(true)
    }

    var showTrailingIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Assist chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show leading icon",
                    checked = showLeadingIcon,
                    onCheckedChange = { showLeadingIcon = it }
                )
                CheckboxWithText(
                    text = "Show trailing icon",
                    checked = showTrailingIcon,
                    onCheckedChange = { showTrailingIcon = it }
                )
            }
        },
        content = {
            AssistChip(
                onClick = { },
                label = {
                    Text(text = "Chip")
                },
                trailingIcon = {
                    MyAnimatedVisibility(visible = showTrailingIcon) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    }
                },
                leadingIcon = {
                    MyAnimatedVisibility(visible = showLeadingIcon) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                },
                enabled = enabled
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyElevatedAssistChip() {
    var enabled by remember {
        mutableStateOf(true)
    }

    var showLeadingIcon by remember {
        mutableStateOf(true)
    }

    var showTrailingIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Elevated assist chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show leading icon",
                    checked = showLeadingIcon,
                    onCheckedChange = { showLeadingIcon = it }
                )
                CheckboxWithText(
                    text = "Show trailing icon",
                    checked = showTrailingIcon,
                    onCheckedChange = { showTrailingIcon = it }
                )
            }
        },
        content = {
            ElevatedAssistChip(
                onClick = { },
                label = {
                    Text(text = "Chip")
                },
                trailingIcon = {
                    MyAnimatedVisibility(visible = showTrailingIcon) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    }
                },
                leadingIcon = {
                    MyAnimatedVisibility(visible = showLeadingIcon) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                },
                enabled = enabled
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MySuggestionChip() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Suggestion chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show icon",
                    checked = showIcon,
                    onCheckedChange = { showIcon = it }
                )
            }
        },
        content = {
            SuggestionChip(
                onClick = { },
                label = {
                    Text(text = "Chip")
                },
                icon = {
                    MyAnimatedVisibility(visible = showIcon) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    }
                },
                enabled = enabled
            )
        }
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyElevatedSuggestionChip() {
    var enabled by remember {
        mutableStateOf(true)
    }
    var showIcon by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Elevated suggestion chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show icon",
                    checked = showIcon,
                    onCheckedChange = { showIcon = it }
                )
            }
        },
        content = {
            ElevatedSuggestionChip(
                onClick = { },
                label = {
                    Text(text = "Chip")
                },
                icon = {
                    MyAnimatedVisibility(visible = showIcon) {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    }
                },
                enabled = enabled
            )
        }
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyFilterChip() {
    var enabled by remember {
        mutableStateOf(true)
    }

    var showLeadingIcon by remember {
        mutableStateOf(true)
    }

    var showTrailingIcon by remember {
        mutableStateOf(false)
    }

    var number by remember {
        mutableIntStateOf(0)
    }
    BasicWidgetFormat(
        headline = "Filter chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show leading icon",
                    checked = showLeadingIcon,
                    onCheckedChange = { showLeadingIcon = it }
                )
                CheckboxWithText(
                    text = "Show trailing icon",
                    checked = showTrailingIcon,
                    onCheckedChange = { showTrailingIcon = it }
                )
            }
        },
        content = {
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                repeat(3) {
                    FilterChip(
                        selected = number == it,
                        onClick = { number = it },
                        label = {
                            Text(text = "Chip ${it + 1}")
                        },
                        trailingIcon = {
                            MyAnimatedVisibility(visible = showTrailingIcon) {
                                Icon(imageVector = Icons.Default.Done, contentDescription = null)
                            }
                        },
                        leadingIcon = {
                            MyAnimatedVisibility(visible = showLeadingIcon) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                            }
                        },
                        enabled = enabled
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyElevatedFilterChip() {
    var enabled by remember {
        mutableStateOf(true)
    }

    var showLeadingIcon by remember {
        mutableStateOf(true)
    }

    var showTrailingIcon by remember {
        mutableStateOf(false)
    }

    var number by remember {
        mutableIntStateOf(0)
    }
    BasicWidgetFormat(
        headline = "Elevated filter chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show leading icon",
                    checked = showLeadingIcon,
                    onCheckedChange = { showLeadingIcon = it }
                )
                CheckboxWithText(
                    text = "Show trailing icon",
                    checked = showTrailingIcon,
                    onCheckedChange = { showTrailingIcon = it }
                )
            }
        },
        content = {
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                repeat(3) {
                    ElevatedFilterChip(
                        selected = number == it,
                        onClick = { number = it },
                        label = {
                            Text(text = "Chip ${it + 1}")
                        },
                        trailingIcon = {
                            MyAnimatedVisibility(visible = showTrailingIcon) {
                                Icon(imageVector = Icons.Default.Done, contentDescription = null)
                            }
                        },
                        leadingIcon = {
                            MyAnimatedVisibility(visible = showLeadingIcon) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                            }
                        },
                        enabled = enabled
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyInputChip() {
    var enabled by remember {
        mutableStateOf(true)
    }

    var showLeadingIcon by remember {
        mutableStateOf(true)
    }

    var showTrailingIcon by remember {
        mutableStateOf(false)
    }

    var number by remember {
        mutableIntStateOf(0)
    }

    var showAvatar by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(
        headline = "Input chip",
        outSideContent = {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = enabled,
                    onCheckedChange = { enabled = it })
                CheckboxWithText(
                    text = "Show leading icon",
                    checked = showLeadingIcon,
                    onCheckedChange = { showLeadingIcon = it }
                )
                CheckboxWithText(
                    text = "Show trailing icon",
                    checked = showTrailingIcon,
                    onCheckedChange = { showTrailingIcon = it }
                )
                CheckboxWithText(
                    text = "Show avatar",
                    checked = showAvatar,
                    onCheckedChange = { showAvatar = it })
            }
        },
        content = {
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                repeat(3) {
                    InputChip(
                        selected = number == it,
                        onClick = { number = it },
                        label = {
                            Text(text = "Chip ${it + 1}")
                        },
                        trailingIcon = {
                            MyAnimatedVisibility(visible = showTrailingIcon) {
                                Icon(imageVector = Icons.Default.Done, contentDescription = null)
                            }
                        },
                        leadingIcon = {
                            MyAnimatedVisibility(visible = showLeadingIcon) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                            }
                        },
                        avatar = {
                            MyAnimatedVisibility(visible = showAvatar) {
                                Image(
                                    painter = painterResource(id = R.drawable.p1),
                                    contentDescription = null,
                                    Modifier.size(24.dp)
                                )
                            }
                        },
                        enabled = enabled
                    )
                }

            }
        }
    )
}