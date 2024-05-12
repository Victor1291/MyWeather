package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shu.entity.IHour

@Entity(tableName = "hours")
data class HourDbo(
    @PrimaryKey
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("city")
    val city: String,
    @ColumnInfo(name = "time_epoch") override val timeEpoch: Int?,
    @ColumnInfo(name = "time") override val time: String?,
    @ColumnInfo(name = "temp_c") override val tempC: Double?,
    @ColumnInfo(name = "temp_f") override val tempF: Double?,
    @ColumnInfo(name = "is_day") override val isDay: Int?,
    @Embedded("condition") override val condition: ConditionDbo? = ConditionDbo(),
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

) : IHour {
    companion object {

        fun toBd(ihour: IHour,city: String): HourDbo {
            return HourDbo(
                name = "$city${ihour.time}",
                city = city,
                timeEpoch = ihour.timeEpoch,
                time = ihour.time,
                tempC = ihour.tempC,
                tempF = ihour.tempF,
                isDay = ihour.isDay,
                condition = ConditionDbo(
                    text = ihour.condition?.text,
                    icon = ihour.condition?.icon,
                    code = ihour.condition?.code
                ),
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

        }
    }
}
