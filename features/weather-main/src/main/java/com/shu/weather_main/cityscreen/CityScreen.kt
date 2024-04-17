package com.shu.weather_main.cityscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.weather_main.WeatherMainViewModel


@Composable
fun CityScreen(
    viewModel: WeatherMainViewModel,
    modifier: Modifier = Modifier,
    onCityClicked: (String?) -> Unit
) {
    val city by viewModel.city.collectAsState()

        LazyColumn(
            contentPadding = PaddingValues(4.dp),
            modifier = modifier
                .padding(top = 65.dp, bottom = 65.dp)
        ) {

            items(city.size) { num ->
                CityCard(location = city[num], onCityClicked)
            }
        }
}







