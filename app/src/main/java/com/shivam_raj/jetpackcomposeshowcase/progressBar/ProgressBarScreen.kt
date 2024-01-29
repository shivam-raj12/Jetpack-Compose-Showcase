package com.shivam_raj.jetpackcomposeshowcase.progressBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProgressBarScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Progress bar",
        description = R.string.progress_bar,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { MyIndeterminateProgressBar()},
            { MyDeterminateProgressBar() },
            { MyIndeterminateCircularProgressBar() },
            { MyDeterminateCircularProgressBar() },
        )
    )
}

@Composable
fun MyIndeterminateProgressBar() {
    BasicWidgetFormat(
        headline = "Indeterminate progress bar"
    ) {
        LinearProgressIndicator(Modifier.fillMaxWidth())
    }
}

@Composable
fun MyDeterminateProgressBar() {
    var progress by remember {
        mutableStateOf(30f)
    }
    BasicWidgetFormat(
        headline = "Determinate progress bar",
        outSideContent = {
            Text(
                text = "Progress value = ${progress.toInt()}",
                style = MaterialTheme.typography.titleMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { progress -= 1 },
                    enabled = progress > 0
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { progress -= 10 },
                    enabled = progress >= 10
                ) {
                    Text(text = "-10")
                }
                Button(
                    onClick = { progress += 10 },
                    enabled = progress <= 90
                ) {
                    Text(text = "+10")
                }
                Button(
                    onClick = { progress += 1 },
                    enabled = progress < 100
                ) {
                    Text(text = "+1")
                }
            }
        }
    ) {
        LinearProgressIndicator(
            progress = {
                progress / 100f
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}


@Composable
fun MyIndeterminateCircularProgressBar() {
    BasicWidgetFormat(
        headline = "Indeterminate circular progress bar"
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MyDeterminateCircularProgressBar() {
    var progress by remember {
        mutableStateOf(30f)
    }
    BasicWidgetFormat(
        headline = "Determinate circular progress bar",
        outSideContent = {
            Text(
                text = "Progress value = ${progress.toInt()}",
                style = MaterialTheme.typography.titleMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { progress -= 1 },
                    enabled = progress > 0
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { progress -= 10 },
                    enabled = progress >= 10
                ) {
                    Text(text = "-10")
                }
                Button(
                    onClick = { progress += 10 },
                    enabled = progress <= 90
                ) {
                    Text(text = "+10")
                }
                Button(
                    onClick = { progress += 1 },
                    enabled = progress < 100
                ) {
                    Text(text = "+1")
                }
            }
        }
    ) {
        CircularProgressIndicator(
            progress = {
                progress / 100f
            },
        )
    }
}