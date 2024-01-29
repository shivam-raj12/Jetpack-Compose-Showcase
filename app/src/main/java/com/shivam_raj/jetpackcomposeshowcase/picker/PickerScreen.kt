package com.shivam_raj.jetpackcomposeshowcase.picker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Destination
@Composable
fun PickerScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Date picker",
        description = R.string.date_picker,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyDatePicker() },
            { MyDateRangePicker() }
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePicker() {
    var show by remember {
        mutableStateOf(false)
    }
    var date by remember {
        mutableLongStateOf(System.currentTimeMillis())
    }
    val state = rememberDatePickerState(
        initialSelectedDateMillis = date
    )
    BasicWidgetFormat(
        headline = "Date picker",
        outSideContent = {
            Text(text = "Selected date : ${dateFormatter(date)}")
        },
        content = {
            Button(onClick = { show = !show }) {
                Text(text = "Open date picker")
            }
        }
    )

    if (show) {
        DatePickerDialog(
            onDismissRequest = { show = false },
            confirmButton = {
                Button(onClick = {
                    show = false
                    date = state.selectedDateMillis ?: System.currentTimeMillis()
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { show = false }) {
                    Text(text = "Dismiss")
                }
            }
        ) {
            DatePicker(state = state)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateRangePicker() {
    var show by remember {
        mutableStateOf(false)
    }
    var endDate by remember {
        mutableLongStateOf(System.currentTimeMillis() + 432000000)
    }
    var startDate by remember {
        mutableLongStateOf(System.currentTimeMillis())
    }
    val state = rememberDateRangePickerState(
        initialSelectedStartDateMillis = startDate,
        initialSelectedEndDateMillis = endDate
    )

    BasicWidgetFormat(
        headline = "Date picker",
        outSideContent = {
            Column {
                Text(text = "Start date : ${dateFormatter(startDate)}")
                Text(text = "End date : ${dateFormatter(endDate)}")
            }
        },
        content = {
            Button(onClick = { show = !show }) {
                Text(text = "Open date picker")
            }
        }
    )

    if (show) {
        DatePickerDialog(
            onDismissRequest = { show = false },
            confirmButton = {
                TextButton(onClick = {
                    show = false
                    startDate = state.selectedStartDateMillis ?: System.currentTimeMillis()
                    endDate =
                        state.selectedEndDateMillis ?: (System.currentTimeMillis() + 432000000)
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { show = false }) {
                    Text(text = "Dismiss")
                }
            }
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                DateRangePicker(
                    state = state,
                    modifier = Modifier.fillMaxHeight(0.9f),
                    title = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Select Date",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    },
                    headline = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = dateFormatter(
                                    state.selectedStartDateMillis ?: 0,
                                    "dd MM yyyy"
                                ),
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                )
            }
        }
    }
}

fun dateFormatter(date: Long, pattern: String = "EEEE, dd MMM yyyy"): String {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.format(Date(date))
}