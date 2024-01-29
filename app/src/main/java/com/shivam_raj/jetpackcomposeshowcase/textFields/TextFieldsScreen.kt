package com.shivam_raj.jetpackcomposeshowcase.textFields

import androidx.compose.runtime.Composable
import com.shivam_raj.jetpackcomposeshowcase.MyScaffold
import com.shivam_raj.jetpackcomposeshowcase.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun TextFieldsScreen(
    navigator: DestinationsNavigator = EmptyDestinationsNavigator
) {
    MyScaffold(
        title = "Text field",
        description = R.string.text_field,
        onBackButtonClick = { navigator.popBackStack() },
        contentList = listOf(
            { TextField() },
            { OutlineTextField() },
        )
    )
}