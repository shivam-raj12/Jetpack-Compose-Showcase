package com.shivam_raj.jetpackcomposeshowcase.bottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun BottomSheetScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Bottom sheet",
        description = R.string.bottom_sheet,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf {
            FullScreenBottomSheet()
        })
}

@Composable
fun BottomSheetContent() {
    LazyColumn {
        items(30) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        ),

                    contentAlignment = Alignment.Center
                ) {
                    Text(text = it.toString(), color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(Modifier.weight(1f)) {
                    Text(text = "Headline", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Supporting text", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreenBottomSheet() {
    var showSheet by remember {
        mutableStateOf(false)
    }
    BasicWidgetFormat(headline = "Bottom sheet") {
        Button(onClick = { showSheet = !showSheet }) {
            Text(text = "Show bottom sheet")
        }
    }
    if (showSheet) {
        ModalBottomSheet(onDismissRequest = { showSheet = false }) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                BottomSheetContent()
            }
        }
    }
}
