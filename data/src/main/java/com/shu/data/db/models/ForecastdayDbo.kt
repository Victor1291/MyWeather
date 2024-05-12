package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.shu.entity.IAstro
import com.shu.entity.IDay
import com.shu.entity.IForecastday
import com.shu.entity.IHour


@Entity(tableName = "forecast")
data class ForecastdayDbo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "day_id")
    val dayId: Int = 0,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "date")
    override val date: String?,
    @ColumnInfo(name = "date_epoch")
    override val dateEpoch: Int?,
    @Embedded("day")
    override val day: DayDbo?,
    @Embedded("astro")
    override val astro: AstroDbo?,

    ) : IForecastday {

    companion object {

        fun toBd(cur: IForecastday, city: String): ForecastdayDbo {
            return ForecastdayDbo(
                date = cur.date,
                city = city,
                dateEpoch = cur.dateEpoch,
                day = DayDbo(
                    maxtempC = cur.day?.maxtempC,
                    maxtempF = cur.day?.maxtempF,
                    mintempC = cur.day?.mintempC,
                    avgtempC = cur.day?.avgtempC,
                    avgtempF = cur.day?.avgtempF,
                    maxwindMph = cur.day?.maxwindMph,
                    maxwindKph = cur.day?.maxwindKph,
                    totalprecipMm = cur.day?.totalprecipMm,
                    totalprecipIn = cur.day?.totalprecipIn,
                    totalsnowCm = cur.day?.totalsnowCm,
                    avgvisKm = cur.day?.avgvisKm,
                    avgvisMiles = cur.day?.avgvisMiles,
                    avghumidity = cur.day?.avghumidity,
                    dailyWillItRain = cur.day?.dailyWillItRain,
                    dailyChanceOfRain = cur.day?.dailyChanceOfRain,
                    dailyWillItSnow = cur.day?.dailyWillItSnow,
                    dailyChanceOfSnow = cur.day?.dailyChanceOfSnow,
                    condition = ConditionDbo(
                        text = cur.day?.condition?.text,
                        icon = cur.day?.condition?.icon,
                        code = cur.day?.condition?.code,
                    ),
                    uv = cur.day?.uv,
                ),
                astro = AstroDbo(
                    sunrise = cur.astro?.sunrise,
                    sunset = cur.astro?.sunset,
                    moonrise = cur.astro?.moonrise,
                    moonset = cur.astro?.moonset,
                    moonPhase = cur.astro?.moonPhase,
                    moonIllumination = cur.astro?.moonIllumination,
                    isMoonUp = cur.astro?.isMoonUp,
                    isSunUp = cur.astro?.isSunUp,
                ),
                /* hour = cur.hour.map { ihour ->
                     HourDbo(
                         timeEpoch = ihour.timeEpoch,
                         time = ihour.time,
                         tempC = ihour.tempC,
                         tempF = ihour.tempF,
                         isDay = ihour.isDay,
                         condition = ihour.condition,
                         windMph = ihour.windMph,
                         windKph = ihour.windKph,
                         windDegree = ihour.windDegree,
                         windDir = ihour.windDir,
                         pressureMb = ihour.pressureMb,
                         pressureIn = ihour.pressureIn,
                         precipMm = ihour.precipMm,
                         precipIn = ihour.precipIn,
                         snowCm = ihour.snowCm,
                         humidity = ihour.humidity,
                         cloud = ihour.cloud,
                         feelslikeC = ihour.feelslikeC,
                         feelslikeF = ihour.feelslikeF,
                         windchillC = ihour.windchillC,
                         windchillF = ihour.windchillF,
                         heatindexC = ihour.heatindexC,
                         heatindexF = ihour.heatindexF,
                         dewpointC = ihour.dewpointC,
                         dewpointF = ihour.dewpointF,
                         willItRain = ihour.willItRain,
                         chanceOfRain = ihour.chanceOfRain,
                         willItSnow = ihour.willItSnow,
                         chanceOfSnow = ihour.chanceOfSnow,
                         visKm = ihour.visKm,
                         visMiles = ihour.visMiles,
                         gustMph = ihour.gustMph,
                         gustKph = ihour.gustKph,
                         uv = ihour.uv,
                     )

                 }*/

            )
        }
    }

    @Ignore
    override var hours: List<IHour> = emptyList()
}


data class DayDbo(
    @ColumnInfo(name = "maxtemp_c") override val maxtempC: Double?,
    @ColumnInfo(name = "maxtemp_f") override val maxtempF: Double?,
    @ColumnInfo(name = "mintemp_c") override val mintempC: Double?,
    @ColumnInfo(name = "avgtemp_c") override val avgtempC: Double?,
    @ColumnInfo(name = "avgtemp_f") override val avgtempF: Double?,
    @ColumnInfo(name = "maxwind_mph") override val maxwindMph: Double?,
    @ColumnInfo(name = "maxwind_kph") override val maxwindKph: Double?,
    @ColumnInfo(name = "totalprecip_mm") override val totalprecipMm: Double?,
    @ColumnInfo(name = "totalprecip_in") override val totalprecipIn: Double?,
    @ColumnInfo(name = "totalsnow_cm") override val totalsnowCm: Double?,
    @ColumnInfo(name = "avgvis_km") override val avgvisKm: Double?,
    @ColumnInfo(name = "avgvis_miles") override val avgvisMiles: Double?,
    @ColumnInfo(name = "avghumidity") override val avghumidity: Int?,
    @ColumnInfo(name = "daily_will_it_rain") override val dailyWillItRain: Int?,
    @ColumnInfo(name = "daily_chance_of_rain") override val dailyChanceOfRain: Int?,
    @ColumnInfo(name = "daily_will_it_snow") override val dailyWillItSnow: Int?,
    @ColumnInfo(name = "daily_chance_of_snow") override val dailyChanceOfSnow: Int?,
    @Embedded("condition") override val condition: ConditionDbo?,
    @ColumnInfo(name = "uv") override val uv: Double?

) : IDay

data class AstroDbo(
    @ColumnInfo(name = "sunrise") override var sunrise: String?,
    @ColumnInfo(name = "sunset") override var sunset: String?,
    @ColumnInfo(name = "moonrise") override var moonrise: String?,
    @ColumnInfo(name = "moonset") override var moonset: String?,
    @ColumnInfo(name = "moon_phase") override var moonPhase: String?,
    @ColumnInfo(name = "moon_illumination") override var moonIllumination: Double?,
    @ColumnInfo(name = "is_moon_up") override var isMoonUp: Int?,
    @ColumnInfo(name = "is_sun_up") override var isSunUp: Int?

) : IAstro

