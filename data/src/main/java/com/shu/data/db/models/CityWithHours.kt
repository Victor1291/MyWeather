package com.shu.data.db.models

import androidx.room.Embedded
import androidx.room.Relation

data class CityWithHours(
    @Embedded
    val forecastDay: ForecastdayDbo,
    @Relation(
        entity = HourDbo::class,
        parentColumn = "day_id",
        entityColumn = "time_epoch"
    )
    val hours: List<HourDbo>?
)
