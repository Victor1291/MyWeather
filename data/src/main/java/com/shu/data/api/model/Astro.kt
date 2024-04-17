package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.IAstro

data class Astro(
    @SerializedName("sunrise"           ) override var sunrise          : String? = null,
    @SerializedName("sunset"            ) override var sunset           : String? = null,
    @SerializedName("moonrise"          ) override var moonrise         : String? = null,
    @SerializedName("moonset"           ) override var moonset          : String? = null,
    @SerializedName("moon_phase"        ) override var moonPhase        : String? = null,
    @SerializedName("moon_illumination" ) override var moonIllumination : Double?    = null,
    @SerializedName("is_moon_up"        ) override var isMoonUp         : Int?    = null,
    @SerializedName("is_sun_up"         ) override var isSunUp          : Int?    = null
): IAstro
