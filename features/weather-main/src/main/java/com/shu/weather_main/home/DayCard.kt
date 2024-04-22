package com.shu.weather_main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shu.entity.IForecastday
import com.shu.weather_main.R

@Composable
fun DayCard(
    forecastDays: IForecastday
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.padding_smaller)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.height))

    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_large))
                .fillMaxWidth()
        ) {

            Text(
                text = forecastDays.date ?: "no data",
                color = MaterialTheme.colorScheme.primary
            )

            forecastDays.day?.avgtempC.let {
                if (it != null) {
                    Text(
                        text = if (it >= 0) "+$it" else "$it",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            AsyncImage(
                modifier = Modifier
                    .width(dimensionResource(R.dimen.size_icon))
                    .height(dimensionResource(R.dimen.size_icon)),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https:${forecastDays.day?.condition?.icon}")
                    .build(),
                contentDescription = "icon"
            )
        }
    }
}