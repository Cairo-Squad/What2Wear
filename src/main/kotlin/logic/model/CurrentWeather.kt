package logic.model

import kotlinx.datetime.LocalTime

data class CurrentWeather(
    val temperature: Double,
    val time: LocalTime,
    val weatherCode: Int,
)