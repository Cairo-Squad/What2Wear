package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDTO(
    val interval: Int?,
    @SerialName("is_day")
    val isDay: Int?,
    val temperature: Double?,
    val time: String?,
    @SerialName("weathercode")
    val weatherCode: Int?,
    @SerialName("winddirection")
    val windDirection: Int?,
    @SerialName("windspeed")
    val windSpeed: Double?
)