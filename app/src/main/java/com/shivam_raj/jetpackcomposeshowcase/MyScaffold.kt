package com.shivam_raj.jetpackcomposeshowcase

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.WidgetSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(
    title: String,
    description: Int,
    onBackButtonClick: () -> Unit,
    contentList: List<@Composable () -> Unit>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title)
                },
                navigationIcon = {
                    IconButton(onClick = onBackButtonClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)) {
            item {
                Text(
                    text = stringResource(id = description),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 6.dp)
                )
                WidgetSpace()
            }
            items(contentList) {
                it()
            }
        }
    }
}