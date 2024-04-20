package com.shu.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shu.data.db.WeatherDatabase
import com.shu.data.db.dao.WeatherDao
import com.shu.data.db.models.AstroDbo
import com.shu.data.db.models.ConditionDbo
import com.shu.data.db.models.DayDbo
import com.shu.data.db.models.ForecastdayDbo
import com.shu.data.db.models.LocationDbo
import com.shu.data.db.models.WeatherDbo
import com.shu.entity.models.Forecast
import com.shu.entity.models.Weather
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

const val TEST_CITY1 = "Vladivostok"
const val TEST_CITY2 = "Moscow"
const val CURRENT_DAY = "2024-04-30"

private lateinit var weatherDatabase: WeatherDatabase
private lateinit var weatherDao: WeatherDao

@RunWith(AndroidJUnit4::class)
class WeatherDaoTest {
    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        weatherDatabase = Room.inMemoryDatabaseBuilder(
            context, WeatherDatabase::class.java
        ).build()

        weatherDao = weatherDatabase.weatherDao()
    }

    @After
    fun tearDown() {
        weatherDatabase.close()
    }

    @Test
    fun save_and_retrieve_weather_data() = runTest {

        // When
        weatherDao.saveInBd(
            TEST_CITY1,
            Weather(
                location = locationDbo,
                current = weatherDbo,
                forecast = forecast
            )
        )

        val savedWeather = weatherDao.weatherFromBd(TEST_CITY1)

        // Then
        assertEquals(1, savedWeather.forecast.forecastday.size)
        assertEquals(TEST_CITY1, savedWeather.location.name)
        assertEquals(CURRENT_DAY, savedWeather.forecast.forecastday[0].date)
    }

    @Test
    fun save_and_retrieve_weather_data_two_city() = runTest {

        // When
        weatherDao.saveInBd(
            TEST_CITY1,
            Weather(
                location = locationDbo,
                current = weatherDbo,
                forecast = forecast
            )
        )
        weatherDao.saveInBd(
            TEST_CITY2,
            Weather(
                location = locationDbo.copy(name = TEST_CITY2),
                current = weatherDbo,
                forecast = forecast
            )
        )


        val savedWeather = weatherDao.weatherFromBd(TEST_CITY2)

        // Then
        assertEquals(1, savedWeather.forecast.forecastday.size)
        assertEquals(TEST_CITY2, savedWeather.location.name)
        assertEquals(CURRENT_DAY, savedWeather.forecast.forecastday[0].date)
    }

}

val conditionDbo = ConditionDbo(
    text = "Test text",
    icon = "test pic",
    code = 0
)

val astroDbo = AstroDbo(
    sunrise = "test sunrise",
    sunset = "sunset",
    moonrise = "moonrise",
    moonset = "moonset",
    moonPhase = "moonPhase",
    moonIllumination = 0.0,
    isMoonUp = 0,
    isSunUp = 0,
)

val weatherDbo = WeatherDbo(
    name = TEST_CITY1,
    tempC = 0.0,
    isDay = 0,
    condition = conditionDbo,
    windKph = 0.0,
    windDir = "West",
    pressureMb = 0.0,
    pressureIn = 0.0,
    precipIn = 0.0,
    humidity = 0,
    cloud = 0,
    feelslikeC = 0.0,
    precipMm = 0.0
)

val locationDbo =
    LocationDbo(
        name = TEST_CITY1,
        region = "Test Region",
        country = "Test Country",
        lat = 0.0,
        lon = 0.0,
        tzId = "tzId",
        localtimeEpoch = 1111,
        localtime = "2024-04-30"
    )

val forecastDbo = ForecastdayDbo(
    date = CURRENT_DAY,
    city = TEST_CITY1,
    dateEpoch = 1,
    day = DayDbo(
        maxtempC = 0.0,
        maxtempF = 0.0,
        mintempC = 0.0,
        avgtempC = 0.0,
        avgtempF = 0.0,
        maxwindMph = 0.0,
        maxwindKph = 0.0,
        totalprecipMm = 0.0,
        totalprecipIn = 0.0,
        totalsnowCm = 0.0,
        avgvisKm = 0.0,
        avgvisMiles = 0.0,
        avghumidity = 0,
        dailyWillItRain = 0,
        dailyChanceOfRain = 0,
        dailyWillItSnow = 0,
        dailyChanceOfSnow = 0,
        condition = conditionDbo,
        uv = 0.0,
    ),
    astro = astroDbo
)

val forecast = Forecast(forecastday = listOf(forecastDbo))

