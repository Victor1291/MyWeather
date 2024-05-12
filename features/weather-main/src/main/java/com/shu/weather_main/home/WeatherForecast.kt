package com.shu.weather_main.home

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.shu.entity.IWeather
import com.shu.weather_main.R

@Composable
fun WeatherForecast(
    weather: IWeather,
    modifier: Modifier,
    state: LazyListState = rememberLazyListState(),
    // onCharacterClicked: (ListItem) -> Unit
) {
    Column(
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_large)))
        Text(
            text = "${weather.location?.name ?: "no name"} ",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
        )
        weather.current?.tempC.let {
            if (it != null) {
                Text(
                    text = if (it >= 0) "+$it" else "$it",
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
        Text(
            text = " ${weather.current.condition?.text ?: "no name"} ",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
        )
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_smaller)),
            modifier = modifier,
            state = state
        ) {

            weather.forecast?.forecastday?.let { forecast ->
                items(forecast.size) { day ->
                    DayCard(forecast[day])
                }
            }
        }

        ListHours(hours = weather.forecast.forecastday.first().hours, modifier = modifier)
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_large)))
    }
}






