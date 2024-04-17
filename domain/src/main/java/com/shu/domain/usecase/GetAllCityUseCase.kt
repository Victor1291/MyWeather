package com.shu.domain.usecase

import com.shu.domain.repository.WeatherRepository
import com.shu.entity.ILocation
import javax.inject.Inject

class GetAllCityUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(): List<ILocation> {

        return repository.getCity()
    }

}