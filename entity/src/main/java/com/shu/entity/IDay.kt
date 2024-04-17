package com.shu.entity

interface IDay {

    val maxtempC          : Double?
    val maxtempF          : Double?
    val mintempC          : Double?
    val avgtempC          : Double?
    val avgtempF          : Double?
    val maxwindMph        : Double?
    val maxwindKph        : Double?
    val totalprecipMm     : Double?
    val totalprecipIn     : Double?
    val totalsnowCm       : Double?
    val avgvisKm          : Double?
    val avgvisMiles       : Double?
    val avghumidity       : Int?
    val dailyWillItRain   : Int?
    val dailyChanceOfRain : Int?
    val dailyWillItSnow   : Int?
    val dailyChanceOfSnow : Int?
    val condition         : ICondition?
    val uv                : Double?

}