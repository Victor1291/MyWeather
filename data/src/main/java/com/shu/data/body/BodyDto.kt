package com.shu.data.body

import com.google.gson.annotations.SerializedName
import com.shu.entity.body.IBody
import com.shu.entity.body.ILocations


data class BodyDto (

  @SerializedName("locations" ) override var locations : List<ILocations>

): IBody