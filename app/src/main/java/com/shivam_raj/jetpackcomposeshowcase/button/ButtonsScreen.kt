package com.shivam_raj.jetpackcomposeshowcase.button

import androidx.compose.runtime.Composable

import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun ButtonsScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Button",
        description = R.string.button,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { Button() },
            { MyOutlineButton() },
            { ElevatedButton() },
            { TextButton() },
            { FilledTonalButton() },
            { IconButton() },
            { FilledIconButton() },
            { OutlinedIconButton() },
            { FilledTonalIconButton() },
            { IconToggleButton() },
            { FilledIconToggleButton() },
            { OutlinedIconToggleButton() },
            { FilledTonalIconToggleButton() },
            { SmallFloatingButton() },
            { FloatingActionButton() },
            { LargeFloatingButton() },
            { ExtendedFloatingButton() },
            { MyCheckBox() },
            { MyTriStateCheckBox() },
            { MyRadioButton() },
            { MySwitch() },
            { MyMultiChoiceSegmentedButton() },
            { MySegmentedButton()}
        )
    )
}