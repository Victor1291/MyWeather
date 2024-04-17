package com.shu.domain.usecase

import android.util.Log
import com.shu.domain.repository.WeatherRepository
import com.shu.entity.IWeather
import javax.inject.Inject

class GetAllWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(city: String,currentDay: String): IWeather {
        val new = repository.getWeather(city,currentDay)
        Log.d("Use case weather", "city ${new.location?.name} ${new.current?.tempC}")
        return new
    }

}