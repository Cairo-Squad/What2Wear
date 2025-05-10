package logic.model

import kotlinx.datetime.LocalTime

data class CurrentWeather(
    val temperature: Double? = null,
    val time: LocalTime? = null,
    val weatherCode: Int? = null
)
