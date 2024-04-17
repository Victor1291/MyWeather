package com.shu.entity.models

import com.shu.entity.ICondition
import com.shu.entity.ICurrent

data class Current(
    override val tempC: Double?,
    override val isDay: Int?,
    override val condition: ICondition?,
    override val windKph: Double?,
    override val windDir: String?,
    override val pressureMb: Double?,
    override val pressureIn: Double?,
    override val precipMm: Double?,
    override val precipIn: Double?,
    override val humidity: Int?,
    override val cloud: Int?,
    override val feelslikeC: Double?

) : ICurrent {

}
