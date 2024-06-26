package com.shu.weather_main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shu.entity.IHour

@Composable
fun HoursCard(
    hours: IHour
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(4.dp)

    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .padding(4.dp)
        ) {

            Text(
                text = hours.time?.takeLast(5) ?: "no data",
                color = MaterialTheme.colorScheme.primary
            )

            hours.tempC?.let {
                Text(
                    text = if (it >= 0) "+$it" else "$it",
                    color = MaterialTheme.colorScheme.primary
                )
            }

            AsyncImage(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https:${hours.condition?.icon}")
                    .build(),
                contentDescription = "icon"
            )
            Text(
                text =  hours.pressureIn.toString() ,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}