package com.shu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shu.data.db.dao.WeatherDao
import com.shu.data.db.models.ForecastdayDbo
import com.shu.data.db.models.LocationDbo
import com.shu.data.db.models.LocationToForecastDbo
import com.shu.data.db.models.WeatherDbo


@Database(
    entities = [
        WeatherDbo::class,
        LocationDbo::class,
        ForecastdayDbo::class,
        LocationToForecastDbo::class,
    ], version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}

