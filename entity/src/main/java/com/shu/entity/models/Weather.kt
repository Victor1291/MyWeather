package com.shu.entity.models

import com.shu.entity.ICurrent
import com.shu.entity.IForecast
import com.shu.entity.ILocation
import com.shu.entity.IWeather

data class Weather(
    override val location: ILocation,
    override val current: ICurrent,
    override val forecast: IForecast
) : IWeather
