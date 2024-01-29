package com.shivam_raj.jetpackcomposeshowcase.basicComponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DropDownSelector(
    dropDownSelectorItem: DropDownSelectorItem
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "${dropDownSelectorItem.title}:-")
        Spacer(modifier = Modifier.width(5.dp))
        Box {
            OutlinedButton(onClick = { expanded = !expanded }) {
                Text(text = dropDownSelectorItem.selected.toString())
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                dropDownSelectorItem.itemList.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it.toString()) },
                        onClick = { dropDownSelectorItem.onClick(it);expanded = false })
                }
            }
        }
    }
}

@Immutable
data class DropDownSelectorItem(
    val title: String,
    val itemList: List<Any>,
    val selected: Any,
    val onClick: (Any) -> Unit
)