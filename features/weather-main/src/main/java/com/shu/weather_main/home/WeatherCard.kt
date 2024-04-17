package com.shu.weather_main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shu.entity.IWeather
import com.shu.weather_main.WeatherMainViewModel

@Composable
fun WeatherCard(
    weather: IWeather,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        ElevatedCardExample(weather)
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedCardExample(weather)
        Spacer(modifier = Modifier.height(8.dp))
        ElevatedCardExample(weather)
    }
}

@Composable
fun ElevatedCardExample(weather: IWeather) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)

    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            weather.location?.name?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            weather.current?.tempC.let {
                if (it != null) {
                    Text(
                        text = if (it >= 0) "+$it" else "$it",
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            AsyncImage(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https:${weather.current?.condition?.icon}")
                    .build(),
                contentDescription = "icon"
            )
        }
    }
}
