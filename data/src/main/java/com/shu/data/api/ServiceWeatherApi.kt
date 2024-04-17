package com.shu.data.api

import com.shu.data.api.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "7318671b1cfa4a6f830150545242203"

/**
 * API details [here](https://www.weatherapi.com/docs/#intro-request)
 */
interface ServiceWeatherApi {


    @GET("forecast.json")
    suspend fun postCurrent(
        @Query("q") q: String = "Moscow",
        @Query("lang") lang: String = "ru",
        @Query("key") key: String = API_KEY,
        @Query("days") days: Int = 3,
    ): WeatherDto

}
