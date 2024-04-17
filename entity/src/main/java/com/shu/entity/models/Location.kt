package com.shu.entity.models

import com.shu.entity.ILocation

data class Location(
    override val name: String,
    override val region: String?,
    override val country: String?,
    override val lat: Double?,
    override val lon: Double?,
    override val tzId: String?,
    override val localtimeEpoch: Int?,
    override val localtime: String?,
) : ILocation {

    companion object {
        fun NONE() : ILocation {
            return Location(
                name = "",
            region = null,
            country = null,
            lat = null,
            lon = null,
            tzId = null,
            localtimeEpoch = null,
            localtime = null,
            )
        }
    }
}
