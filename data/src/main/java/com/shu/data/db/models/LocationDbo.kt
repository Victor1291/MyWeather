package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shu.entity.ILocation

@Entity(tableName = "location")
data class LocationDbo(
    @PrimaryKey
    @ColumnInfo("name")
    override val name: String,
    @ColumnInfo("region")
    override val region: String?,
    @ColumnInfo("country")
    override val country: String?,
    @ColumnInfo("lat")
    override val lat: Double?,
    @ColumnInfo("lon")
    override val lon: Double?,
    @ColumnInfo("tz_id")
    override val tzId: String?,
    @ColumnInfo("localtime_epoch")
    override val localtimeEpoch: Int?,
    @ColumnInfo("localtime")
    override val localtime: String?,
) : ILocation {

    companion object {

        fun toBd(loc: ILocation): LocationDbo {
            return LocationDbo(
                name = loc.name,
                region = loc.region,
                country = loc.country,
                lat = loc.lat,
                lon = loc.lon,
                tzId = loc.tzId,
                localtimeEpoch = loc.localtimeEpoch,
                localtime = loc.localtime
            )
        }
    }
}