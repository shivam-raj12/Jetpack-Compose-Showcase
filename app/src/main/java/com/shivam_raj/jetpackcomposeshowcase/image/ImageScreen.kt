package com.shivam_raj.jetpackcomposeshowcase.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shivam_raj.jetpackcomposeshowcase.R
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelector
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.ChipSelectorItems
import com.shivam_raj.jetpackcomposeshowcase.basicComponent.WidgetSpace
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

val list = listOf(
    ContentScale.Crop,
    ContentScale.Fit,
    ContentScale.FillBounds,
    ContentScale.FillHeight,
    ContentScale.Inside,
    ContentScale.FillWidth,
    ContentScale.None
)

val textList = listOf(
    "Crop",
    "Fit",
    "FillBounds",
    "FillHeight",
    "Inside",
    "FillWidth",
    "None"
)

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ImageScreen(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator
) {
    var selected by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Image")
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.image),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            )
            WidgetSpace()
            Image(
                painter = painterResource(id = R.drawable.p1),
                contentDescription = null,
                contentScale = list[selected],
                modifier = Modifier
                    .size(400.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ChipSelector(
                chipSelectorItems = ChipSelectorItems(
                    title = "Scale",
                    itemList = list,
                    itemNameList = textList,
                    selected = selected,
                    onClick = { selected = it })
            )

        }
    }
}