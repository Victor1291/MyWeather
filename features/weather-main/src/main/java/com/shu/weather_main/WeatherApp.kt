package com.shu.weather_main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WeatherApp(
    viewModel: WeatherMainViewModel,
    modifier: Modifier = Modifier,
    /* onCharacterClicked: (ListItem) -> Unit*/
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(
            viewModel,
            modifier = modifier,
            // onCharacterClicked
        )
    }
}