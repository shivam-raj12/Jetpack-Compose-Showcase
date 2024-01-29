package com.shivam_raj.jetpackcomposeshowcase.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.shivam_raj.jetpackcomposeshowcase.basicComponent.BasicWidgetFormat
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AnimationScreen(
    navigator: DestinationsNavigator
) {
    MyScaffold(
        title = "Animations",
        description = R.string.animations,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { AnimateColorAsStateSample() },
            { AnimateFloatAsStateSample() },
            { AnimateDpAsStateSample() },
            { AnimateContentSample()}
        )
    )
}

@Composable
fun AnimateColorAsStateSample() {
    val list = remember {
        listOf(
            Color.Red,
            Color.Green,
            Color.Blue,
            Color.Yellow,
            Color.Black,
            Color.Magenta,
            Color.Cyan,
            Color(255, 192, 203),
            Color(150, 75, 0),
        )
    }
    var h by remember {
        mutableIntStateOf(0)
    }
    val color by animateColorAsState(
        targetValue = list[h],
        label = "color",
        animationSpec = tween(1000)
    )
    BasicWidgetFormat(headline = "animateColorAsState sample", outSideContent = {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Button(onClick = { if (h != list.size - 1) h++ else h = 0 }) {
                Text(text = "Animate color")
            }
        }
    }) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color)
        )
    }
}


@Composable
fun AnimateFloatAsStateSample() {
    var h by remember {
        mutableFloatStateOf(0f)
    }
    val angle by animateFloatAsState(targetValue = h, label = "float", animationSpec = tween(1000))
    BasicWidgetFormat(headline = "animateFloatAsState sample", outSideContent = {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Button(onClick = { h = if (h == 0f) 360f else 0f }) {
                Text(text = "Animate float")
            }
        }
    }) {
        Icon(
            imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
            Modifier
                .background(Color.Black)
                .size(100.dp)
                .rotate(angle), tint = Color.White
        )
    }
}

@Composable
fun AnimateDpAsStateSample() {
    var h by remember {
        mutableStateOf(100.dp)
    }
    val dp by animateDpAsState(targetValue = h, label = "float", animationSpec = tween(1000))
    BasicWidgetFormat(
        headline = "animateDpAsState sample", outSideContent = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                Button(onClick = { h = if (h == 100.dp) 200.dp else 100.dp }) {
                    Text(text = "Animate dp")
                }
            }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Favorite, contentDescription = null,
            Modifier.size(dp),
            tint = Color.Red
        )
    }
}

@Composable
fun AnimateContentSample() {
    var number by remember {
        mutableIntStateOf(1)
    }
    BasicWidgetFormat(
        headline = "AnimateContent sample", outSideContent = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedIconButton(onClick = { number-- }) {
                    Text(text = "-1")
                }
                OutlinedIconButton(onClick = { number++ }) {
                    Text(text = "+1")
                }
            }
        }
    ) {
        AnimatedContent(
            targetState = number,
            label = "Animate content",
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { it } + fadeIn() togetherWith
                            slideOutVertically { -it } + fadeOut()
                } else {
                    slideInVertically { -it } + fadeIn() togetherWith
                            slideOutVertically { it } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(
                text = targetCount.toString(),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}