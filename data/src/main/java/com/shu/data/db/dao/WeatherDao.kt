package com.shu.data.db.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.shu.data.db.models.CitiesDbo
import com.shu.data.db.models.ForecastdayDbo
import com.shu.data.db.models.LocationDbo
import com.shu.data.db.models.WeatherDbo
import com.shu.entity.IWeather
import com.shu.entity.models.Forecast
import com.shu.entity.models.Weather
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {

    @Transaction
    suspend fun saveInBd(city: String,weatherNew: IWeather) {
        Log.d("dao", "****************** saveInbd *********************")
        insertCity(CitiesDbo(name = city))

        clearForecast(city)
        //Save to BD
        insertWeather(WeatherDbo.toBd(weatherNew.current, city))
        insertLocation(LocationDbo.toBd(weatherNew.location))

        insertForecast(weatherNew.forecast.forecastday.map {
            ForecastdayDbo.toBd(it, city)
        })
    }

    @Transaction
    suspend fun weatherFromBd(city: String): IWeather {

        val getCityFromDb = getCityLocation(city)
        //Loading from BD
        val getCityWeather = getCityWeather(city)
        val getCityForecast = getCityForecast(city)
        return Weather(
            location = getCityFromDb,
            current = getCityWeather,
            forecast = Forecast(forecastday = getCityForecast)
        )
    }

    @Transaction
    suspend fun allWeatherFromBd(): List<IWeather> {
        val listWeather = mutableListOf<IWeather>()
        val getCityFromDb = getCity()
        getCityFromDb.forEach {city ->
            val getCityWeather = getCityWeather(city.name)
            val getCityForecast = getCityForecast(city.name)
            listWeather.add(
                Weather(
                    location = city,
                    current = getCityWeather,
                    forecast = Forecast(forecastday = getCityForecast)
                )
            )
        }
       return listWeather.toList()
    }


    @Query("SELECT * FROM weather")
    suspend fun getAll(): List<WeatherDbo>

    @Query("SELECT * FROM location")
    suspend fun getCity(): List<LocationDbo>

    @Query("SELECT * FROM location WHERE name = :city ")
    suspend fun getCityLocation(city: String): LocationDbo


    @Query("SELECT * FROM weather WHERE name = :city ")
    suspend fun getCityWeather(city: String): WeatherDbo

    @Query("SELECT * FROM forecast WHERE city = :city ")
    suspend fun getCityForecast(city: String): List<ForecastdayDbo>

    @Query("DELETE FROM forecast WHERE city = :city")
    suspend fun clearForecast(city: String)

    @Query("SELECT * FROM weather")
    fun observeAll(): Flow<List<WeatherDbo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCity(city: CitiesDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(listLocation: LocationDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(listLocation: List<ForecastdayDbo>)

    @Delete
    suspend fun removeWeather(listWeather: List<WeatherDbo>)

    @Delete
    suspend fun removeLocation(listLocation: List<LocationDbo>)

    @Query("DELETE FROM weather")
    suspend fun cleanWeather()

    @Query("DELETE FROM location")
    suspend fun cleanLocation()

}