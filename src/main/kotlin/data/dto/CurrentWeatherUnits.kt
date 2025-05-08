package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnits(
    val interval: String?,
    @SerialName("is_day")
    val isDay: String?,
    val temperature: String?,
    val time: String?,
    @SerialName("weathercode")
    val weatherCode: String?,
    @SerialName("winddirection")
    val windDirection: String?,
    @SerialName("windspeed")
    val windSpeed: String?
)