package com.shu.weather_main.cityscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.weather_main.WeatherMainViewModel
import com.shu.weather_main.home.DayCard

@Composable
fun DetailScreen(
    viewModel: WeatherMainViewModel,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
) {

    val forecastday by viewModel.weather.collectAsState()

    Column(
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "${viewModel.choiceCity ?: "no name"} ",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
        )
        LazyColumn(
            contentPadding = PaddingValues(4.dp),
            modifier = modifier,
            state = state
        ) {

            forecastday.let { forecast ->
                items(forecast.size) { day ->
                    DayCard(forecast[day])
                }
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}