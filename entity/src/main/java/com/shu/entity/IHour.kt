package com.shu.entity

interface IHour {
    val timeEpoch: Int?
    val time: String?
    val tempC: Double?
    val tempF: Double?
    val isDay: Int?
    val condition: ICondition?
    val windMph: Double?
    val windKph: Double?
    val windDegree: Int?
    val windDir: String?
    val pressureMb: Double?
    val pressureIn: Double?
    val precipMm: Double?
    val precipIn: Double?
    val snowCm: Double?
    val humidity: Int?
    val cloud: Int?
    val feelslikeC: Double?
    val feelslikeF: Double?
    val windchillC: Double?
    val windchillF: Double?
    val heatindexC: Double?
    val heatindexF: Double?
    val dewpointC: Double?
    val dewpointF: Double?
    val willItRain: Int?
    val chanceOfRain: Int?
    val willItSnow: Int?
    val chanceOfSnow: Int?
    val visKm: Double?
    val visMiles: Double?
    val gustMph: Double?
    val gustKph: Double?
    val uv: Double?

}