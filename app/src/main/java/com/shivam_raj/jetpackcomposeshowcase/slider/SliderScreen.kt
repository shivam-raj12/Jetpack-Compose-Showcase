package com.shivam_raj.jetpackcomposeshowcase.slider

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
fun SliderScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Slider",
        description = R.string.slider,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { ContinuousSlider() },
            { ContinuousRangeSlider() },
            { DiscreteSlider() },
            { DiscreteRangeSlider() },
        )
    )
}

@Composable
fun ContinuousSlider() {
    var value by remember {
        mutableIntStateOf(0)
    }
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Continuous slider",
        outSideContent = {
            Text(text = "Slider value = $value", style = MaterialTheme.typography.titleMedium)
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Slider(
            value = value.toFloat(),
            onValueChange = { value = it.toInt() },
            valueRange = 0f..100f,
            enabled = enabled
        )
    }
}

@Composable
fun ContinuousRangeSlider() {
    var value by remember {
        mutableStateOf(0f..100f)
    }
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Range slider",
        outSideContent = {
            Text(
                text = "Slider value = ${value.start.toInt()} to ${value.endInclusive.toInt()}",
                style = MaterialTheme.typography.titleMedium
            )
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        RangeSlider(
            value = value,
            onValueChange = { value = it },
            valueRange = 0f..100f,
            enabled = enabled
        )
    }
}

@Composable
fun DiscreteSlider() {
    var value by remember {
        mutableIntStateOf(0)
    }
    BasicWidgetFormat(
        headline = "Discrete slider",
        outSideContent = {
            Text(text = "Slider value = $value", style = MaterialTheme.typography.titleMedium)
        }
    ) {
        Slider(
            value = value.toFloat(),
            onValueChange = { value = it.toInt() },
            valueRange = 0f..100f,
            steps = 9
        )
    }
}

@Composable
fun DiscreteRangeSlider() {
    var value by remember {
        mutableStateOf(0f..100f)
    }
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Discrete range slider",
        outSideContent = {
            Text(
                text = "Slider value = ${value.start.toInt()} to ${value.endInclusive.toInt()}",
                style = MaterialTheme.typography.titleMedium
            )
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        RangeSlider(
            value = value,
            onValueChange = { value = it },
            valueRange = 0f..100f,
            enabled = enabled,
            steps = 19
        )
    }
}