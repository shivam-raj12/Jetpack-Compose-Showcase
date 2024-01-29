package com.shivam_raj.jetpackcomposeshowcase.basicComponent

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChipSelector(
    chipSelectorItems: ChipSelectorItems
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${chipSelectorItems.title}:- ",
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            repeat(chipSelectorItems.itemList.size) {
                FilterChip(
                    selected = chipSelectorItems.selected == it,
                    onClick = { chipSelectorItems.onClick(it) },
                    label = {
                        Text(
                            text = (chipSelectorItems.itemNameList
                                ?: chipSelectorItems.itemList)[it].toString()
                        )
                    })
            }
        }
    }
}

@Immutable
data class ChipSelectorItems(
    val title: String,
    val itemList: List<Any>,
    val itemNameList: List<String>? = null,
    val selected: Int,
    val onClick: (Int) -> Unit
)