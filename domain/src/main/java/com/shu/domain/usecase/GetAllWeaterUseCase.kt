package com.shu.domain.usecase

import com.shu.domain.repository.WeatherRepository
import com.shu.entity.CityItem
import com.shu.entity.IWeather
import javax.inject.Inject

class GetAllWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(city: String, currentDay: String): IWeather {
        return repository.getWeather(city, currentDay)
    }

    suspend fun allWeatherFromBd(): CityItem {

        val listWeather = repository.allWeatherFromBd().takeLast(10).reversed()

        val listName = mutableListOf<String>()
        val list1 = mutableListOf<String>()
        val list2 = mutableListOf<String>()
        val list3 = mutableListOf<String>()
        listName.add("")
        list1.add("day temperature  ")
        list2.add("day temperature  ")
        list3.add("day temperature  ")
        val mapTable = mutableMapOf<Int, List<String>>()
        listWeather.map { weather ->
            listName.add(weather.location.name)
            list1.add(" ${weather.forecast.forecastday[0].date.toString().takeLast(2)} ${weather.forecast.forecastday[0].day?.avgtempC} ${weather.forecast.forecastday[0].day?.condition?.text}")
            list2.add(" ${weather.forecast.forecastday[1].date.toString().takeLast(2)} ${weather.forecast.forecastday[1].day?.avgtempC} ${weather.forecast.forecastday[1].day?.condition?.text}")
            list3.add(" ${weather.forecast.forecastday[2].date.toString().takeLast(2)} ${weather.forecast.forecastday[2].day?.avgtempC} ${weather.forecast.forecastday[2].day?.condition?.text}")
        }
        mapTable[1] = list1
        mapTable[2] = list2
        mapTable[3] = list3

        return CityItem(
            listCity = listName,
            tempTable = mapTable
        )
    }

}

/*

list<City>
Map<City, List<String>>.toList()




city         data1, data2, data3
moscow         10     11    21
vladivostok    14     16    18
 */