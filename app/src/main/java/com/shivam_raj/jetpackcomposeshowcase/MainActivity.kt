package com.shivam_raj.jetpackcomposeshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.Direction
import com.shivam_raj.jetpackcomposeshowcase.destinations.AnimationScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.AppBarScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.BadgeScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.BottomSheetScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ButtonsScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.CardScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ChipScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.DialogBoxScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ImageScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.LayoutScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.NavigationRailScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.PagerScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.PickerScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ProgressBarScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.SliderScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.SnackBarScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.TabsScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.TextFieldsScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.TextScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.destinations.ToolTipScreenDestination
import com.shivam_raj.jetpackcomposeshowcase.ui.theme.JetpackComposeShowcaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            val engine = rememberNavHostEngine()
            JetpackComposeShowcaseTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    engine = engine,
                    navController = engine.rememberNavController()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
@RootNavGraph(start = true)
fun MainScreen(
    navigator: DestinationsNavigator
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val expanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction < 0.5f }
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = if (expanded) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = if (expanded) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            itemsIndexed(getList()) { index: Int, item: String ->
                SingleListItem(name = item) {
                    navigator.navigate(direction = getDirection(index))
                }
            }
        }
    }
}

@Composable
fun SingleListItem(
    name: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .defaultMinSize(minHeight = 56.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
            .clickable {
                onClick()
            }
            .padding(start = 16.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

fun getList(): List<String> {
    return listOf(
        "Text",
        "Button",
        "Image",
        "Text Field",
        "Pager",
        "Badge",
        "Tooltip",
        "Chip",
        "Card",
        "Progress Bar",
        "Slider",
        "Snackbar",
        "Bottom sheet",
        "Dialog box",
        "Date picker",
        "Tabs",
        "Navigation rail",
        "App bar",
        "Animations",
        "Layouts"
    )
}

fun getDirection(index: Int): Direction {
    return when (index) {
        0 -> TextScreenDestination
        1 -> ButtonsScreenDestination
        2 -> ImageScreenDestination
        3 -> TextFieldsScreenDestination
        4 -> PagerScreenDestination
        5 -> BadgeScreenDestination
        6 -> ToolTipScreenDestination
        7 -> ChipScreenDestination
        8 -> CardScreenDestination
        9 -> ProgressBarScreenDestination
        10 -> SliderScreenDestination
        11 -> SnackBarScreenDestination
        12 -> BottomSheetScreenDestination
        13 -> DialogBoxScreenDestination
        14 -> PickerScreenDestination
        15 -> TabsScreenDestination
        16 -> NavigationRailScreenDestination
        17 -> AppBarScreenDestination
        18 -> AnimationScreenDestination
        else -> LayoutScreenDestination
    }
}

@Immutable
data class Item(
    val string: String,
    val direction: Direction
)