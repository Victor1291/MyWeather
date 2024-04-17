package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shu.entity.IAstro
import com.shu.entity.ICondition
import com.shu.entity.IDay
import com.shu.entity.IForecastday
import com.shu.entity.IHour


@Entity(tableName = "forecast")
data class ForecastdayDbo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
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
    /*  @Embedded("hour")
      override val hour: List<HourDbo>*/

) : IForecastday {

    companion object {

        fun toBd(cur: IForecastday,city: String): ForecastdayDbo {
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
                )
            )
        }
    }

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

data class HourDbo(
    @ColumnInfo(name = "time_epoch") override val timeEpoch: Int?,
    @ColumnInfo(name = "time") override val time: String?,
    @ColumnInfo(name = "temp_c") override val tempC: Double?,
    @ColumnInfo(name = "temp_f") override val tempF: Double?,
    @ColumnInfo(name = "is_day") override val isDay: Int?,
    @ColumnInfo(name = "condition") override val condition: ICondition?,
    @ColumnInfo(name = "wind_mph") override val windMph: Double?,
    @ColumnInfo(name = "wind_kph") override val windKph: Double?,
    @ColumnInfo(name = "wind_degree") override val windDegree: Int?,
    @ColumnInfo(name = "wind_dir") override val windDir: String?,
    @ColumnInfo(name = "pressure_mb") override val pressureMb: Double?,
    @ColumnInfo(name = "pressure_in") override val pressureIn: Double?,
    @ColumnInfo(name = "precip_mm") override val precipMm: Double?,
    @ColumnInfo(name = "precip_in") override val precipIn: Double?,
    @ColumnInfo(name = "snow_cm") override val snowCm: Double?,
    @ColumnInfo(name = "humidity") override val humidity: Int?,
    @ColumnInfo(name = "cloud") override val cloud: Int?,
    @ColumnInfo(name = "feels_like_c") override val feelslikeC: Double?,
    @ColumnInfo(name = "feels_like_f") override val feelslikeF: Double?,
    @ColumnInfo(name = "windchill_c") override val windchillC: Double?,
    @ColumnInfo(name = "windchill_f") override val windchillF: Double?,
    @ColumnInfo(name = "heatindex_c") override val heatindexC: Double?,
    @ColumnInfo(name = "heatindex_f") override val heatindexF: Double?,
    @ColumnInfo(name = "dewpoint_c") override val dewpointC: Double?,
    @ColumnInfo(name = "dewpoint_f") override val dewpointF: Double?,
    @ColumnInfo(name = "will_it_rain") override val willItRain: Int?,
    @ColumnInfo(name = "chance_of_rain") override val chanceOfRain: Int?,
    @ColumnInfo(name = "will_it_snow") override val willItSnow: Int?,
    @ColumnInfo(name = "chance_of_snow") override val chanceOfSnow: Int?,
    @ColumnInfo(name = "vis_km") override val visKm: Double?,
    @ColumnInfo(name = "vis_miles") override val visMiles: Double?,
    @ColumnInfo(name = "dgust_mph") override val gustMph: Double?,
    @ColumnInfo(name = "gust_kph") override val gustKph: Double?,
    @ColumnInfo(name = "uv") override val uv: Double?

) : IHour