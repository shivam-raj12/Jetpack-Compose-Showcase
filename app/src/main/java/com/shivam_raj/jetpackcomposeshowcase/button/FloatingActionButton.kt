package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

@Composable
fun FloatingActionButton() {
    BasicWidgetFormat(
        headline = "Floating action button"
    ) {
        FloatingActionButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Create, contentDescription = null)
        }
    }
}


@Composable
fun LargeFloatingButton() {
    BasicWidgetFormat(
        headline = "Large floating action button"
    ) {
        LargeFloatingActionButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Create, contentDescription = null)
        }
    }
}

@Composable
fun SmallFloatingButton() {
    BasicWidgetFormat(
        headline = "Small floating action button"
    ) {
        SmallFloatingActionButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Create, contentDescription = null)
        }
    }
}

@Composable
fun ExtendedFloatingButton() {
    var extended by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Extended floating action button",
        outSideContent = {
            CheckboxWithText(
                text = "Expanded",
                checked = extended,
                onCheckedChange = { extended = it })
        }
    ) {
        ExtendedFloatingActionButton(
            text = {
                Text(text = "Create")
            },
            icon = {
                Icon(imageVector = Icons.Default.Create, contentDescription = null)
            },
            onClick = { },
            expanded = extended
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMultiChoiceSegmentedButton() {
    BasicWidgetFormat(
        headline = "Multi choice segmented button",
        content = {
            MultiChoiceSegmentedButtonRow {
                repeat(4) { index ->
                    var checked by remember {
                        mutableStateOf(false)
                    }
                    SegmentedButton(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        icon = {
                            if (checked) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = null)
                            }
                        },
                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 10.dp else 0.dp,
                            topEnd = if (index == 3) 10.dp else 0.dp,
                            bottomStart = if (index == 0) 10.dp else 0.dp,
                            bottomEnd = if (index == 3) 10.dp else 0.dp,
                        ),
                        label = {
                            Text(text = "Button ${index + 1}")
                        }
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySegmentedButton() {
    var number by remember {
        mutableIntStateOf(-1)
    }
    BasicWidgetFormat(
        headline = "Single choice segmented button",
        content = {
            SingleChoiceSegmentedButtonRow {
                repeat(4) { index ->
                    SegmentedButton(
                        selected = number == index,
                        onClick = { number = index },
                        icon = {
                            if (number == index) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = null)
                            }
                        },
                        label = {
                            Text(text = "Item ${index + 1}")
                        },
                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 10.dp else 0.dp,
                            topEnd = if (index == 3) 10.dp else 0.dp,
                            bottomStart = if (index == 0) 10.dp else 0.dp,
                            bottomEnd = if (index == 3) 10.dp else 0.dp,
                        )
                    )
                }
            }
        }
    )
}