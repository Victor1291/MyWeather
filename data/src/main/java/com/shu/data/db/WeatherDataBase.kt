package com.shu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shu.data.db.dao.WeatherDao
import com.shu.data.db.models.CitiesDbo
import com.shu.data.db.models.ForecastdayDbo
import com.shu.data.db.models.HourDbo
import com.shu.data.db.models.LocationDbo
import com.shu.data.db.models.WeatherDbo


@Database(
    entities = [
        CitiesDbo::class,
        WeatherDbo::class,
        LocationDbo::class,
        ForecastdayDbo::class,
        HourDbo::class,
    ], version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}

