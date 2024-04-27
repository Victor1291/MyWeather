package com.shu.weather_main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shu.datastore.DataStoreDataSource
import com.shu.domain.usecase.GetAllCityUseCase
import com.shu.domain.usecase.GetAllWeatherUseCase
import com.shu.domain.usecase.GetWeatherUseCase
import com.shu.entity.CityItem
import com.shu.entity.IForecastday
import com.shu.entity.ILocation
import com.shu.entity.IWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject


sealed interface UiState {
    data class Success(val weather: IWeather) : UiState
    data object Error : UiState
    data object Loading : UiState
}

@HiltViewModel
class WeatherMainViewModel @Inject constructor(
    private val getAllWeatherUseCase: GetAllWeatherUseCase,
    private val getAllCityUseCase: GetAllCityUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val dataStoreDataSource: DataStoreDataSource
) : ViewModel() {

    var choiceCity: String = ""


    val currentDay = getTime()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _stateTOpBar = MutableStateFlow<Boolean>(true)
    val stateTOpBar: StateFlow<Boolean> = _stateTOpBar.asStateFlow()

    private val _city = MutableStateFlow<List<ILocation>>(emptyList())
    val city = _city.asStateFlow()

    private val _weather = MutableStateFlow<List<IForecastday>>(emptyList())
    val weather = _weather.asStateFlow()

    private val _weatherAll = MutableStateFlow(CityItem(emptyList(), emptyMap()))
    val weatherAll = _weatherAll.asStateFlow()


    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: androidx.compose.runtime.State<String> = _searchTextState


    private fun getTime(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun changeStateTOpBar(stateNew: Boolean) {
        _stateTOpBar.value = stateNew
    }

    init {
        getCityFromDataSource()
    }

    fun getWeather(query: String = "") {
        viewModelScope.launch {
            _uiState.emit(UiState.Loading)

            try {
                val response = getAllWeatherUseCase.invoke(query, currentDay)
                _uiState.emit(UiState.Success(response))
                saveCity(response.location.name)
            } catch (e: Exception) {
                Log.e("viewmodelError", "Error $e")
                _uiState.emit(UiState.Error)
            }
        }
    }

    fun getAllWeather() {
        viewModelScope.launch {
            try {
                val response = getAllWeatherUseCase.allWeatherFromBd()
                _weatherAll.emit(response)
            } catch (e: Exception) {
                Log.e("viewmodel- getAll", "Error $e")
            }
        }
    }

    fun getAllCity() {
        viewModelScope.launch {
            _city.value = getAllCityUseCase.invoke()
        }
    }

    fun getWeather() {
        viewModelScope.launch {
            _weather.value = getWeatherUseCase.invoke(choiceCity).forecast.forecastday
        }
    }

    private fun saveCity(city: String) {
        choiceCity = city
        viewModelScope.launch {
            dataStoreDataSource.saveCity(city)
        }
    }

    private fun getCityFromDataSource() {
        viewModelScope.launch {
            dataStoreDataSource.city.collect {
                choiceCity = it
                updateSearchTextState(it)
                getWeather(it)
                getAllCity()
            }
        }
    }



}
