package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.body.IBody
import com.shu.entity.body.ILocations

data class BodyRequest (
    @SerializedName("locations" ) override var locations : List<LocationsBody> = listOf()
): IBody

data class LocationsBody (
    @SerializedName("q"         ) override var q        : String? = null,
    @SerializedName("custom_id" ) override var customId : String? = null
): ILocations