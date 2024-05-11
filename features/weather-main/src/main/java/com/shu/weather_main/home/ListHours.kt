package com.shu.weather_main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.entity.IWeather


@Composable
fun ListHours(
    weather: IWeather,
    modifier: Modifier,
    state: LazyListState = rememberLazyListState(),
    // onCharacterClicked: (ListItem) -> Unit
) {
    Column(
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.height(20.dp))
       /* Text(
            text = "${weather.location?.name ?: "no name"} size = ${weather.forecast?.forecastday?.first()?.hour?.size ?: 0}",
            color = MaterialTheme.colorScheme.primary
        )*/
        LazyRow(
            contentPadding = PaddingValues(4.dp),
            modifier = modifier,
            state = state
        ) {

            weather.forecast?.forecastday?.first()?.hour .let { forecast ->
                forecast?.size?.let {
                    items(it) { day ->
                        HoursCard(forecast[day])
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}


