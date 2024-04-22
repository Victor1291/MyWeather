package com.shu.data.repository

import android.util.Log
import com.shu.data.api.ServiceWeatherApi
import com.shu.data.db.dao.WeatherDao
import com.shu.domain.repository.WeatherRepository
import com.shu.entity.ILocation
import com.shu.entity.IWeather
import com.shu.entity.models.Forecast
import com.shu.entity.models.Weather

class WeatherRepositoryImpl(
    private val weatherDao: WeatherDao,
    private val api: ServiceWeatherApi,
) : WeatherRepository {

    override suspend fun getWeather(city: String, currentDay: String): IWeather {
        val weatherNew: IWeather
        val getCityFromDb = weatherDao.getCityLocation(city)

        //&& getCityFromDb.localtime?.take(10) == currentDay
        if (getCityFromDb != null && getCityFromDb.localtime?.take(10) == currentDay) {
            //Loading from BD
//  Log.d("repository", " [${getCityFromDb.localtime?.take(10)}] currentDay [$currentDay]")
            val getCityWeather = weatherDao.getCityWeather(city)
            val getCityForecast = weatherDao.getCityForecast(city)
            weatherNew = Weather(
                location = getCityFromDb,
                current = getCityWeather,
                forecast = Forecast(forecastday = getCityForecast)
            )
        } else {
            //get from API
            weatherNew = api.postCurrent(q = city)
            if (weatherNew.location.name.lowercase().startsWith(city.lowercase())) {
                weatherDao.saveInBd(weatherNew.location.name, weatherNew)
            }
        }
        return weatherNew
    }

    override suspend fun getCity(): List<ILocation> {
        return weatherDao.getCity()
    }

    override suspend fun getWeatherCity(city: String): IWeather {
        return weatherDao.weatherFromBd(city)
    }
}
//        //берём с кэша если есть, операция в прогрессе.
//        //можно назначить customId в body ?  и город или координаты города.
//        //val localCache = weatherDao.observeAll()
//
//        //   emit( RequestResult.InProgress(localCache))
//        val remoteApi = flow {
//            emit(api.postCurrent(body = bodi))
//        }.map { result ->
//            if (result.isSuccess) {
//                val response = result.getOrThrow()
//                response
//            } else {
//            throw result.exceptionOrNull() ?: IOException("Unknown error")
//            }
//        }.onEach {weatherApi ->
//            val current = mutableListOf<ICurrent>()
//            val location = mutableListOf<ILocation>()
//            weatherApi.forEach { weather ->
//                weather.current?.let { current.add(it) }
//                weather.location?.let { location.add(it) }
//            }
//           weatherDao.insertWeather(current.toList() as List<WeatherDbo>)
//           weatherDao.insertLocation(location.toList() as List<LocationDbo>)
//        }
//
//        return remoteApi.map {
//            it as List<ICurrent>
//        }




