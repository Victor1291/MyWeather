package com.shu.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shu.data.api.model.Current
import com.shu.entity.ICondition
import com.shu.entity.ICurrent

@Entity(tableName = "weather")
data class WeatherDbo(
    @PrimaryKey
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("temp_c")      override val tempC: Double? = null,
    @ColumnInfo("is_day")      override val isDay: Int? = null,
    @Embedded("condition")     override val condition: ConditionDbo? = ConditionDbo(),
    @ColumnInfo("wind_kph")    override var windKph: Double? = null,
    @ColumnInfo("wind_dir")    override var windDir: String? = null,
    @ColumnInfo("pressure_mb") override var pressureMb: Double? = null,
    @ColumnInfo("pressure_in") override var pressureIn: Double? = null,
    @ColumnInfo("precip_mm")   override var precipMm: Double? = null,
    @ColumnInfo("precip_in")   override var precipIn: Double? = null,
    @ColumnInfo("humidity")    override var humidity: Int? = null,
    @ColumnInfo("cloud")       override var cloud: Int? = null,
    @ColumnInfo("feelslike_c") override var feelslikeC: Double? = null,
) : ICurrent {

    companion object {
        fun toBd(cur: ICurrent,city: String): WeatherDbo {
            return WeatherDbo(
                name = city,
                tempC = cur.tempC,
                isDay = cur.isDay,
                condition = ConditionDbo(
                    text = cur.condition?.text,
                    icon = cur.condition?.icon,
                    code = cur.condition?.code
                ),
                windKph = cur.windKph,
                windDir = cur.windDir,
                pressureMb = cur.pressureMb,
                pressureIn = cur.pressureIn,
                precipIn = cur.precipIn,
                humidity = cur.humidity,
                cloud = cur.cloud,
                feelslikeC = cur.feelslikeC,
                precipMm = cur.precipMm
            )
        }
    }
}

data class ConditionDbo(

    @ColumnInfo("text") override val text: String? = null,
    @ColumnInfo("icon") override val icon: String? = null,
    @ColumnInfo("code") override val code: Int? = null

) : ICondition