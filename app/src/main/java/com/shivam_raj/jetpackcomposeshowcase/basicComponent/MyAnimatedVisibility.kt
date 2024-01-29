package com.shivam_raj.jetpackcomposeshowcase.basicComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable

@Composable
fun MyAnimatedVisibility(
    visible:Boolean,
    content:@Composable AnimatedVisibilityScope.()->Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut(),
        content = content
    )
}