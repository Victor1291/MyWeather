package com.shu.weather_main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.shu.entity.ILocation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialSearch(
    viewModel: WeatherMainViewModel,
) {
    val isActive = remember {
        mutableStateOf(false)
    }
    val searchTextState = viewModel.searchTextState
    val city by viewModel.city.collectAsState()
    val mainList = remember {
        mutableStateOf(city)
    }
    SearchBar(modifier = Modifier.fillMaxWidth().padding(dimensionResource(R.dimen.padding_medium)),
        query = searchTextState.value,
        onQueryChange = { text ->
            viewModel.updateSearchTextState(text)
            mainList.value = Utils.search(text, city)
        },
        onSearch = {
            if (mainList.value.size == 1) {
                viewModel.getWeather(mainList.value[0].name)
            } else {
                viewModel.getWeather(it)
            }
            isActive.value = false
        },
        placeholder = {
            Text(text = stringResource(R.string.enter_city) )
        },
        active = isActive.value,
        onActiveChange = {
            isActive.value = it
        }) {
        LazyColumn {
            items(mainList.value.size) { item ->
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium)).clickable {
                            viewModel.updateSearchTextState(mainList.value[item].name)
                            viewModel.getWeather(mainList.value[item].name)
                            isActive.value = false
                        }, contentAlignment = Alignment.Center
                ) {
                    Text(text = mainList.value[item].name)
                }
            }
        }
    }
}

object Utils {
    val originUsersList = listOf(
        "Moscow",
        "London",
        "Paris",
        "Vladivostok",
        "Sydney",
        "Sochi",
    )

    fun search(text: String, city: List<ILocation>): List<ILocation> {
        return city.filter {
            it.name.lowercase().startsWith(text.lowercase())
        }
    }
}