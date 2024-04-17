package com.shu.entity

interface IWeather {

  val location: ILocation
  val current: ICurrent
 val forecast : IForecast

}