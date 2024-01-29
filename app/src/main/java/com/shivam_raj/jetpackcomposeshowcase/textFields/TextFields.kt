package com.shivam_raj.jetpackcomposeshowcase.textFields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelector
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelectorItems
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.MyAnimatedVisibility

val list = listOf(
    KeyboardCapitalization.None,
    KeyboardCapitalization.Characters,
    KeyboardCapitalization.Sentences,
    KeyboardCapitalization.Words
)
val type = listOf(
    KeyboardType.Text,
    KeyboardType.Email,
    KeyboardType.Ascii,
    KeyboardType.Decimal,
    KeyboardType.Number,
    KeyboardType.NumberPassword,
    KeyboardType.Password,
    KeyboardType.Phone,
    KeyboardType.Uri
)

val action = listOf(
    ImeAction.Default,
    ImeAction.Done,
    ImeAction.Go,
    ImeAction.None,
    ImeAction.Next,
    ImeAction.Previous,
    ImeAction.Search,
    ImeAction.Send
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TextField(
    state: MyStates = MyStates()
) {
    BasicWidgetFormat(
        headline = "Text field",
        outSideContent = {
            FlowRow(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = state.enabled,
                    onCheckedChange = { state.enabled = it })
                CheckboxWithText(
                    text = "Trailing icon",
                    checked = state.trailingIcon,
                    onCheckedChange = { state.trailingIcon = it })
                CheckboxWithText(
                    text = "Leading icon",
                    checked = state.leadingIcon,
                    onCheckedChange = { state.leadingIcon = it })
                CheckboxWithText(
                    text = "Error",
                    checked = state.error,
                    onCheckedChange = { state.error = it })
                CheckboxWithText(
                    text = "Label",
                    checked = state.label,
                    onCheckedChange = { state.label = it })
                CheckboxWithText(
                    text = "Placeholder",
                    checked = state.placeholder,
                    onCheckedChange = { state.placeholder = it })
                CheckboxWithText(
                    text = "Read only",
                    checked = state.readOnly,
                    onCheckedChange = { state.readOnly = it })
                CheckboxWithText(
                    text = "Single line",
                    checked = state.singleLine,
                    onCheckedChange = { state.singleLine = it })
                CheckboxWithText(
                    text = "Supporting text",
                    checked = state.supportingText,
                    onCheckedChange = { state.supportingText = it })
                CheckboxWithText(
                    text = "Password transformation",
                    checked = state.passwordTransformation,
                    onCheckedChange = { state.passwordTransformation = it })
            }
            ChipSelector(
                ChipSelectorItems(
                    title = "Capitalization",
                    itemList = list,
                    selected = state.capital,
                    onClick = { state.capital = it }
                )
            )
            ChipSelector(
                ChipSelectorItems(
                    title = "Type",
                    itemList = type,
                    selected = state.type,
                    onClick = { state.type = it }
                )
            )
            ChipSelector(
                ChipSelectorItems(
                    title = "Ime action",
                    itemList = action,
                    selected = state.action,
                    onClick = { state.action = it }
                )
            )
        }
    ) {
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            enabled = state.enabled,
            isError = state.error,
            visualTransformation = if (state.passwordTransformation) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = state.singleLine,
            readOnly = state.readOnly,
            trailingIcon = {
                MyAnimatedVisibility(visible = state.trailingIcon) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = null)
                }
            },
            leadingIcon = {
                MyAnimatedVisibility(visible = state.leadingIcon) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            },
            label = {
                MyAnimatedVisibility(visible = state.label) {
                    Text(text = "This is a label")
                }
            },
            placeholder = {
                MyAnimatedVisibility(visible = state.placeholder) {
                    Text(text = "This is a placeholder")
                }
            },
            supportingText = {
                MyAnimatedVisibility(visible = state.supportingText) {
                    Text(text = "This is a supporting text")
                }
            },
            keyboardOptions = KeyboardOptions(
                list[state.capital],
                keyboardType = type[state.type],
                imeAction = action[state.action]
            )
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OutlineTextField(
    state: MyStates = MyStates()
) {
    BasicWidgetFormat(
        headline = "Outline text field",
        outSideContent = {
            FlowRow(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CheckboxWithText(
                    text = "Enabled",
                    checked = state.enabled,
                    onCheckedChange = { state.enabled = it })
                CheckboxWithText(
                    text = "Trailing icon",
                    checked = state.trailingIcon,
                    onCheckedChange = { state.trailingIcon = it })
                CheckboxWithText(
                    text = "Leading icon",
                    checked = state.leadingIcon,
                    onCheckedChange = { state.leadingIcon = it })
                CheckboxWithText(
                    text = "Error",
                    checked = state.error,
                    onCheckedChange = { state.error = it })
                CheckboxWithText(
                    text = "Label",
                    checked = state.label,
                    onCheckedChange = { state.label = it })
                CheckboxWithText(
                    text = "Placeholder",
                    checked = state.placeholder,
                    onCheckedChange = { state.placeholder = it })
                CheckboxWithText(
                    text = "Read only",
                    checked = state.readOnly,
                    onCheckedChange = { state.readOnly = it })
                CheckboxWithText(
                    text = "Single line",
                    checked = state.singleLine,
                    onCheckedChange = { state.singleLine = it })
                CheckboxWithText(
                    text = "Supporting text",
                    checked = state.supportingText,
                    onCheckedChange = { state.supportingText = it })
                CheckboxWithText(
                    text = "Password transformation",
                    checked = state.passwordTransformation,
                    onCheckedChange = { state.passwordTransformation = it })
            }
            ChipSelector(
                ChipSelectorItems(
                    title = "Capitalization",
                    itemList = list,
                    selected = state.capital,
                    onClick = { state.capital = it }
                )
            )
            ChipSelector(
                ChipSelectorItems(
                    title = "Type",
                    itemList = type,
                    selected = state.type,
                    onClick = { state.type = it }
                )
            )
            ChipSelector(
                ChipSelectorItems(
                    title = "Ime action",
                    itemList = action,
                    selected = state.action,
                    onClick = { state.action = it }
                )
            )

        }
    ) {
        OutlinedTextField(
            value = state.value,
            onValueChange = { state.value = it },
            enabled = state.enabled,
            visualTransformation = if (state.passwordTransformation) PasswordVisualTransformation() else VisualTransformation.None,
            isError = state.error,
            singleLine = state.singleLine,
            readOnly = state.readOnly,
            trailingIcon = {
                MyAnimatedVisibility(visible = state.trailingIcon) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = null)
                }
            },
            leadingIcon = {
                MyAnimatedVisibility(visible = state.leadingIcon) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            },
            label = {
                MyAnimatedVisibility(visible = state.label) {
                    Text(text = "This is a label")
                }
            },
            placeholder = {
                MyAnimatedVisibility(visible = state.placeholder) {
                    Text(text = "This is a placeholder")
                }
            },
            supportingText = {
                MyAnimatedVisibility(visible = state.supportingText) {
                    Text(text = "This is a supporting text")
                }
            },
            keyboardOptions = KeyboardOptions(
                list[state.capital],
                keyboardType = type[state.type],
                imeAction = action[state.action]
            )
        )
    }
}


class MyStates {
    var value by mutableStateOf("")
    var enabled by mutableStateOf(true)
    var error by mutableStateOf(false)
    var trailingIcon by mutableStateOf(true)
    var leadingIcon by mutableStateOf(true)
    var label by mutableStateOf(true)
    var placeholder by mutableStateOf(false)
    var readOnly by mutableStateOf(false)
    var singleLine by mutableStateOf(false)
    var supportingText by mutableStateOf(false)
    var passwordTransformation by mutableStateOf(false)
    var capital by mutableIntStateOf(0)
    var type by mutableIntStateOf(0)
    var action by mutableIntStateOf(0)
}