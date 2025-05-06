package logic.model

import java.time.LocalTime

data class CurrentWeather(
    val temperature : Double,
    val time : LocalTime,
    val weatherCode : Int,
)
