package com.shu.domain.usecase

import com.shu.domain.repository.WeatherRepository
import com.shu.entity.IWeather
import javax.inject.Inject

class GetAllWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(city: String, currentDay: String): IWeather {
        return repository.getWeather(city, currentDay)
    }

}