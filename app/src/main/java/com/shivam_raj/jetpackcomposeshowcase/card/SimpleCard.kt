package com.shivam_raj.jetpackcomposeshowcase.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.CheckboxWithText

val elevationList=listOf(1.dp, 3.dp, 5.dp, 7.dp, 9.dp, 11.dp, 13.dp, 15.dp)
@Composable
fun SimpleCard() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Card",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Column {
            elevationList.forEach {
                Card(
                    onClick = {},
                    enabled = enabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = it,
                        disabledElevation = it
                    )
                ) {
                    CardContent("Elevation $it")
                }
                MyCardSpacer()
            }
        }
    }
}

@Composable
fun MyElevatedCard() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Elevated card",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Column {
            elevationList.forEach {
                ElevatedCard(
                    onClick = {},
                    enabled = enabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = it,
                        disabledElevation = it
                    )
                ) {
                    CardContent("Elevation $it")
                }
                MyCardSpacer()
            }
        }
    }
}

@Composable
fun MyOutlinedCard() {
    var enabled by remember {
        mutableStateOf(true)
    }
    BasicWidgetFormat(
        headline = "Outlined card",
        outSideContent = {
            CheckboxWithText(
                text = "Enabled",
                checked = enabled,
                onCheckedChange = { enabled = it })
        }
    ) {
        Column {
            elevationList.forEach {
                OutlinedCard(
                    onClick = {},
                    enabled = enabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = it,
                        disabledElevation = it
                    )
                ) {
                    CardContent("Elevation $it")
                }
                MyCardSpacer()
            }
        }
    }
}

@Composable
fun CardContent(text: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun MyCardSpacer() {
    Spacer(modifier = Modifier.height(15.dp))
}