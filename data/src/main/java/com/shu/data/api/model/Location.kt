package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.ILocation


data class Location (

  @SerializedName("name"            ) override  val name           : String = "",
  @SerializedName("region"          ) override  val region         : String? = null,
  @SerializedName("country"         ) override  val country        : String? = null,
  @SerializedName("lat"             ) override  val lat            : Double? = null,
  @SerializedName("lon"             ) override  val lon            : Double? = null,
  @SerializedName("tz_id"           ) override  val tzId           : String? = null,
  @SerializedName("localtime_epoch" ) override  val localtimeEpoch : Int? = null,
  @SerializedName("localtime"       ) override  val localtime      : String? = null

): ILocation