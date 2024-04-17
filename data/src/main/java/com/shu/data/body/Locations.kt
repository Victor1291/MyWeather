package com.shu.data.body

import com.google.gson.annotations.SerializedName
import com.shu.entity.body.ILocations


data class Locations (

  @SerializedName("q"         ) override var q        : String?,
  @SerializedName("custom_id" ) override var customId : String?

): ILocations