package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("interval")
    val interval: Int?,
    @SerialName("is_day")
    val isDay: Int?,
    @SerialName("temperature")
    val temperature: Double?,
    @SerialName("time")
    val time: String?,
    @SerialName("weathercode")
    val weatherCode: Int?,
    @SerialName("windspeed")
    val windSpeed: Double?
)