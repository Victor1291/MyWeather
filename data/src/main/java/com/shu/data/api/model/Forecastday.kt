package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IForecastday
import com.shu.entity.IHour

data class Forecastday(

    @SerializedName("date"       ) override var date      : String?         = null,
    @SerializedName("date_epoch" ) override var dateEpoch : Int?            = null,
    @SerializedName("day"        ) override var day       : Day?            = Day(),
    @SerializedName("astro"      ) override var astro     : Astro?          = Astro(),
    @SerializedName("hour"       ) override var hours     : List<Hour>      = emptyList()

): IForecastday
