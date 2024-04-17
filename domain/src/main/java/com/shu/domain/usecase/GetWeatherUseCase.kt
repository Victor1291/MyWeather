package com.shu.domain.usecase

import com.shu.domain.repository.WeatherRepository
import com.shu.entity.IForecastday
import com.shu.entity.IWeather
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(city: String): IWeather {

        return repository.getWeatherCity(city)
    }

}