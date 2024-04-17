package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IDay

data class Day(

    @SerializedName("maxtemp_c"            ) override var maxtempC          : Double?    = null,
    @SerializedName("maxtemp_f"            ) override var maxtempF          : Double?    = null,
    @SerializedName("mintemp_c"            ) override var mintempC          : Double?    = null,
    @SerializedName("avgtemp_c"            ) override var avgtempC          : Double?    = null,
    @SerializedName("avgtemp_f"            ) override var avgtempF          : Double?    = null,
    @SerializedName("maxwind_mph"          ) override var maxwindMph        : Double?    = null,
    @SerializedName("maxwind_kph"          ) override var maxwindKph        : Double?    = null,
    @SerializedName("totalprecip_mm"       ) override var totalprecipMm     : Double?    = null,
    @SerializedName("totalprecip_in"       ) override var totalprecipIn     : Double?    = null,
    @SerializedName("totalsnow_cm"         ) override var totalsnowCm       : Double?       = null,
    @SerializedName("avgvis_km"            ) override var avgvisKm          : Double?    = null,
    @SerializedName("avgvis_miles"         ) override var avgvisMiles       : Double?       = null,
    @SerializedName("avghumidity"          ) override var avghumidity       : Int?       = null,
    @SerializedName("daily_will_it_rain"   ) override var dailyWillItRain   : Int?       = null,
    @SerializedName("daily_chance_of_rain" ) override var dailyChanceOfRain : Int?       = null,
    @SerializedName("daily_will_it_snow"   ) override var dailyWillItSnow   : Int?       = null,
    @SerializedName("daily_chance_of_snow" ) override var dailyChanceOfSnow : Int?       = null,
    @SerializedName("condition"            ) override var condition         : Condition? = Condition(),
    @SerializedName("uv"                   ) override var uv                : Double?     = null

) : IDay
