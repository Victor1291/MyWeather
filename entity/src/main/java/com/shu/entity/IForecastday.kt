package com.shu.entity

interface IForecastday {

    val date      : String?
    val dateEpoch : Int?
    val day       : IDay?
    val astro     : IAstro?
   // val hour      : List<IHour>
}