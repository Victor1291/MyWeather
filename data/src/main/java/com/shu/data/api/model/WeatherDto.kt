package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IWeather


data class WeatherDto (

  @SerializedName("location" ) override var location : Location,
  @SerializedName("current"  ) override var current  : Current,
  @SerializedName("forecast" ) override var forecast : Forecast,

): IWeather