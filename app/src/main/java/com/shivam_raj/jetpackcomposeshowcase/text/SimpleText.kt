package com.shivam_raj.jetpackcomposeshowcase.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelector
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelectorItems


val dropDownList = listOf(
    FontFamily.Default,
    FontFamily.Cursive,
    FontFamily.SansSerif,
    FontFamily.Serif,
    FontFamily.Monospace
)

val weight = listOf(
    FontWeight.Thin,
    FontWeight.ExtraLight,
    FontWeight.Light,
    FontWeight.Normal,
    FontWeight.Medium,
    FontWeight.SemiBold,
    FontWeight.Bold,
    FontWeight.ExtraBold,
    FontWeight.Black
)

val stringWeight = listOf(
    "Thin",
    "ExtraLight",
    "Light",
    "Normal",
    "Medium",
    "SemiBold",
    "Bold",
    "ExtraBold",
    "Black",
)

val stringFamily = listOf(
    "Default",
    "Cursive",
    "SansSerif",
    "Serif",
    "Monospace"
)


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SimpleText(
    state: MyTextStates = remember {
        MyTextStates()
    }
) {
    BasicWidgetFormat(
        headline = "Simple text",
        outSideContent = {
            FlowRow(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Show background",
                    checked = state.showBackground,
                    onCheckedChange = { state.showBackground = it }
                )
                CheckboxWithText(
                    text = "Italic style",
                    checked = state.italic,
                    onCheckedChange = { state.italic = it }
                )
                CheckboxWithText(
                    text = "Underline",
                    checked = state.underline,
                    onCheckedChange = { state.underline = it }
                )
                CheckboxWithText(
                    text = "Line through",
                    checked = state.lineThrough,
                    onCheckedChange = { state.lineThrough = it }
                )
                CheckboxWithText(
                    text = "Single line",
                    checked = state.singleLine,
                    onCheckedChange = { state.singleLine = it }
                )
            }
            ChipSelector(
                chipSelectorItems = ChipSelectorItems(
                    title = "Font weight",
                    itemList = weight,
                    itemNameList = stringWeight,
                    selected = state.fontWeight,
                    onClick = { state.fontWeight = it })
            )
            ChipSelector(
                chipSelectorItems = ChipSelectorItems(
                    title = "Font family",
                    itemList = dropDownList,
                    itemNameList = stringFamily,
                    selected = state.fontFamily,
                    onClick = { state.fontFamily = it })
            )
        }
    ) {
        Text(
            text = stringResource(id = R.string.dummy_text),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .background(if (state.showBackground) Color.Gray else Color.Unspecified),
            fontFamily = dropDownList[state.fontFamily],
            fontStyle = if (state.italic) FontStyle.Italic else FontStyle.Normal,
            textDecoration = if (state.underline && !state.lineThrough) {
                TextDecoration.Underline
            } else if (!state.underline && state.lineThrough) {
                TextDecoration.LineThrough
            } else if (state.underline && state.lineThrough) {
                TextDecoration.combine(listOf(TextDecoration.LineThrough, TextDecoration.Underline))
            } else {
                TextDecoration.None
            },
            overflow = TextOverflow.Ellipsis,
            maxLines = if (state.singleLine) 1 else Int.MAX_VALUE,
            fontWeight = weight[state.fontWeight]
        )
    }
}

class MyTextStates {
    var showBackground by mutableStateOf(false)
    var fontFamily by mutableIntStateOf(0)
    var fontWeight by mutableIntStateOf(0)
    var italic by mutableStateOf(false)
    var underline by mutableStateOf(false)
    var lineThrough by mutableStateOf(false)
    var singleLine by mutableStateOf(false)
}