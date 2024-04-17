package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(
    tableName = "location_forecast",
    primaryKeys = ["location_id","forecast_id"]
)
data class LocationToForecastDbo(
    @ColumnInfo(name= "location_id")
    val locationId: Int,
    @ColumnInfo(name= "forecast_id")
    val forecastId: Int
)
