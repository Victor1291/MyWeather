package com.shu.data.api

import com.shu.data.BuildConfig
import com.shu.data.api.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API details [here](https://www.weatherapi.com/docs/#intro-request)
 */
interface ServiceWeatherApi {
    @GET("forecast.json")
    suspend fun postCurrent(
        @Query("q") q: String = "Moscow",
        @Query("lang") lang: String = "ru",
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("days") days: Int = 3,
    ): WeatherDto

}
