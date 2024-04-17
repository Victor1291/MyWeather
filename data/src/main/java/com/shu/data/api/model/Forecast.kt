package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IForecast

data class Forecast(

    @SerializedName("forecastday") override var forecastday: List<Forecastday> = listOf()
) : IForecast
