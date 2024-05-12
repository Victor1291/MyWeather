package com.shu.entity


interface ICurrent {

    val tempC      : Double?
    val isDay      : Int?
    val condition  : ICondition?
    val windKph    : Double?
    val windDir    : String?
    val pressureMb : Double?
    val pressureIn : Double?
    val precipMm   : Double?
    val precipIn   : Double?
    val humidity   : Int?
    val cloud      : Int?
    val feelslikeC : Double?

}