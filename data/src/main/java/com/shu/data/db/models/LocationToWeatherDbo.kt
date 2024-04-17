package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(
    tableName = "location_weather",
    primaryKeys = ["location_id","weather_id"]
)
data class LocationToWeatherDbo(
    @ColumnInfo(name= "location_id")
    val locationId: Int,
    @ColumnInfo(name= "weather_id")
    val weatherId: Int
)
