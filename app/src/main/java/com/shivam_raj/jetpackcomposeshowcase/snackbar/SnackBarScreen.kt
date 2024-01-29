package com.shivam_raj.jetpackcomposeshowcase.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.TriStateCheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.WidgetSpace
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Destination
@Composable
fun SnackBarScreen(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator
) {
    val state = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    var showAction by remember {
        mutableStateOf(false)
    }

    var showDismiss by remember {
        mutableStateOf(false)
    }

    var duration by remember {
        mutableStateOf(ToggleableState.On)
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = state)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Snackbar")
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = stringResource(id = R.string.snack_bar),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            )
            WidgetSpace()
            BasicWidgetFormat(
                headline = "Snackbar",
                outSideContent = {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        CheckboxWithText(
                            text = "Show action",
                            checked = showAction,
                            onCheckedChange = { showAction = it }
                        )
                        CheckboxWithText(
                            text = "Show dismiss icon",
                            checked = showDismiss,
                            onCheckedChange = { showDismiss = it }
                        )
                        TriStateCheckboxWithText(
                            text = "Duration",
                            state = duration,
                            onClick = {
                                duration = when (duration) {
                                    ToggleableState.On -> ToggleableState.Indeterminate
                                    ToggleableState.Off -> ToggleableState.On
                                    else -> ToggleableState.Off
                                }
                            },
                            helperText = when (duration) {
                                ToggleableState.On -> "Short"
                                ToggleableState.Off -> "Long"
                                else -> "Indefinite"
                            }
                        )
                    }
                },
                content = {
                    Button(onClick = {
                        scope.launch {
                            state.showSnackbar(
                                message = "This is a snake bar",
                                actionLabel = if (showAction) "Dismiss" else null,
                                withDismissAction = showDismiss,
                                duration = when (duration) {
                                    ToggleableState.On -> SnackbarDuration.Short
                                    ToggleableState.Off -> SnackbarDuration.Long
                                    else -> SnackbarDuration.Indefinite
                                }
                            )
                        }
                    }) {
                        Text(text = "Show snack bar")
                    }
                }
            )
        }
    }
}