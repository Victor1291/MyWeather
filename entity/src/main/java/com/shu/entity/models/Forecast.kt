package com.shu.entity.models

import com.shu.entity.IForecast
import com.shu.entity.IForecastday

data class Forecast (
    override val forecastday: List<IForecastday>

): IForecast