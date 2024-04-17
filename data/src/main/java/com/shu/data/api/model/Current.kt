package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.ICurrent


data class Current (

    @SerializedName("temp_c"      ) override var tempC      : Double?      = null,
    @SerializedName("is_day"      ) override var isDay      : Int?       = null,
    @SerializedName("condition"   ) override var condition  : Condition? = Condition(),
    @SerializedName("wind_kph"    ) override var windKph    : Double?       = null,
    @SerializedName("wind_dir"    ) override var windDir    : String?    = null,
    @SerializedName("pressure_mb" ) override var pressureMb : Double?       = null,
    @SerializedName("pressure_in" ) override var pressureIn : Double?    = null,
    @SerializedName("precip_mm"   ) override var precipMm   : Double?      = null,
    @SerializedName("precip_in"   ) override var precipIn   : Double?       = null,
    @SerializedName("humidity"    ) override var humidity   : Int?       = null,
    @SerializedName("cloud"       ) override var cloud      : Int?       = null,
    @SerializedName("feelslike_c" ) override var feelslikeC : Double?    = null

    ) : ICurrent