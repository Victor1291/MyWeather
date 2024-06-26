package com.shu.weather_main.cityscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.shu.entity.ILocation
import com.shu.weather_main.R

@Composable
fun CityCard(
    location: ILocation,
    onCityClicked: (String?) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.padding_smaller)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.height))
            .clickable { onCityClicked(location.name) }

    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_large))
                .fillMaxWidth()
        ) {

            Text(
                text = "${location.country}  ${location.name} ${location.localtime} ",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}