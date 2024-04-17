package com.shu.weather_main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.shu.weather_main.home.WeatherForecast
import com.shu.weather_main.state.ErrorScreen
import com.shu.weather_main.state.LoadingScreen


@Composable
fun HomeScreen(
    viewModel: WeatherMainViewModel,
    modifier: Modifier,
) {
    val viewState by viewModel.uiState.collectAsState()


    when (viewState) {
        is UiState.Loading -> LoadingScreen(modifier)
        is UiState.Success -> {
            // Log.d("success", "city in state ${(viewState as UiState.Success).weather.location?.name}")
            WeatherForecast(
                weather = (viewState as UiState.Success).weather,
                modifier
            )
        }

        is UiState.Error -> ErrorScreen(
            retryAction = { viewModel.getWeather(viewModel.searchTextState.value) },
            modifier
        )

    }
}
