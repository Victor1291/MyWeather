package com.shu.domain.repository

import com.shu.entity.IForecastday
import com.shu.entity.ILocation
import com.shu.entity.IWeather

interface WeatherRepository {

    suspend fun getWeather(city: String,currentDay: String): IWeather

    suspend fun getCity() : List<ILocation>
    suspend fun getWeatherCity(city: String): IWeather
    suspend fun allWeatherFromBd(): List<IWeather>



}