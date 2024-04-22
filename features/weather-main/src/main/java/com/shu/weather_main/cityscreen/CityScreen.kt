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

@Composable
fun CityScreen(
    viewModel: WeatherMainViewModel,
    modifier: Modifier = Modifier,
    onCityClicked: (String?) -> Unit
) {
    val city by viewModel.city.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_smaller)),
        modifier = modifier
            .padding(
                top = dimensionResource(R.dimen.height),
                bottom = dimensionResource(R.dimen.height)
            )
    ) {

        items(city.size) { num ->
            CityCard(location = city[num], onCityClicked)
        }
    }
}







