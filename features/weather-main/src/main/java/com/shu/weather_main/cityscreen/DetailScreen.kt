package com.shu.weather_main.cityscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.shu.weather_main.R
import com.shu.weather_main.WeatherMainViewModel
import com.shu.weather_main.home.DayCard
import com.shu.weather_main.home.ListHours

@Composable
fun DetailScreen(
    viewModel: WeatherMainViewModel,
    modifier: Modifier = Modifier,
) {

    val forecastday by viewModel.weather.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_smaller)),
        modifier = modifier
            .padding(
                top = dimensionResource(R.dimen.height),
                bottom = dimensionResource(R.dimen.height)
            )
    ) {

        forecastday.let { forecast ->
            items(forecast.size) { day ->
                DayCard(forecast[day])
                if (day == 0)
                    ListHours(hours = forecast[day].hours.take(24), modifier = modifier)
                if (day == 1)
                    ListHours(hours = forecast[day].hours.subList(24, 48), modifier = modifier)
                if (day == 2)
                    ListHours(hours = forecast[day].hours.takeLast(24), modifier = modifier)
            }
        }
    }
}