package com.shivam_raj.jetpackcomposeshowcase.basicComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState

@Composable
fun CheckboxWithText(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$text:-",
            color = if (enabled) Color.Unspecified else MaterialTheme.colorScheme.outline
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChange, enabled = enabled)
    }
}

@Composable
fun TriStateCheckboxWithText(
    text: String,
    state: ToggleableState,
    onClick: () -> Unit,
    helperText: String?,
    enabled: Boolean = true
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "$text:-")
        TriStateCheckbox(state = state, onClick = onClick, enabled = enabled)
        if (helperText != null) Text(text = "($helperText)")
    }
}