package com.shivam_raj.jetpackcomposeshowcase.fullScreenDemo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedScaffold(
    title: String,
    onCrossClick:()->Unit,
    content:@Composable (PaddingValues)->Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = title)
                },
                actions = {
                    IconButton(onClick = onCrossClick) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) {
        content(it)
    }
}