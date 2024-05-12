package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IHour

data class Hour(
    @SerializedName("time_epoch"     ) override var timeEpoch    : Int?       = null,
    @SerializedName("time"           ) override var time         : String?    = null,
    @SerializedName("temp_c"         ) override var tempC        : Double?    = null,
    @SerializedName("temp_f"         ) override var tempF        : Double?    = null,
    @SerializedName("is_day"         ) override var isDay        : Int?       = null,
    @SerializedName("condition"      ) override var condition    : Condition? = Condition(),
    @SerializedName("wind_mph"       ) override var windMph      : Double?    = null,
    @SerializedName("wind_kph"       ) override var windKph      : Double?    = null,
    @SerializedName("wind_degree"    ) override var windDegree   : Int?       = null,
    @SerializedName("wind_dir"       ) override var windDir      : String?    = null,
    @SerializedName("pressure_mb"    ) override var pressureMb   : Double?       = null,
    @SerializedName("pressure_in"    ) override var pressureIn   : Double?    = null,
    @SerializedName("precip_mm"      ) override var precipMm     : Double?       = null,
    @SerializedName("precip_in"      ) override var precipIn     : Double?       = null,
    @SerializedName("snow_cm"        ) override var snowCm       : Double?       = null,
    @SerializedName("humidity"       ) override var humidity     : Int?       = null,
    @SerializedName("cloud"          ) override var cloud        : Int?       = null,
    @SerializedName("feelslike_c"    ) override var feelslikeC   : Double?    = null,
    @SerializedName("feelslike_f"    ) override var feelslikeF   : Double?    = null,
    @SerializedName("windchill_c"    ) override var windchillC   : Double?    = null,
    @SerializedName("windchill_f"    ) override var windchillF   : Double?    = null,
    @SerializedName("heatindex_c"    ) override var heatindexC   : Double?    = null,
    @SerializedName("heatindex_f"    ) override var heatindexF   : Double?    = null,
    @SerializedName("dewpoint_c"     ) override var dewpointC    : Double?    = null,
    @SerializedName("dewpoint_f"     ) override var dewpointF    : Double?    = null,
    @SerializedName("will_it_rain"   ) override var willItRain   : Int?       = null,
    @SerializedName("chance_of_rain" ) override var chanceOfRain : Int?       = null,
    @SerializedName("will_it_snow"   ) override var willItSnow   : Int?       = null,
    @SerializedName("chance_of_snow" ) override var chanceOfSnow : Int?       = null,
    @SerializedName("vis_km"         ) override var visKm        : Double?       = null,
    @SerializedName("vis_miles"      ) override var visMiles     : Double?       = null,
    @SerializedName("gust_mph"       ) override var gustMph      : Double?    = null,
    @SerializedName("gust_kph"       ) override var gustKph      : Double?       = null,
    @SerializedName("uv"             ) override var uv           : Double?       = null
): IHour


