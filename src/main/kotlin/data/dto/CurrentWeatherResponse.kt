package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("current_weather")
    val currentWeather: CurrentWeatherDTO?,
    @SerialName("current_weather_units")
    val currentWeatherUnits: CurrentWeatherUnits?,
    val elevation: Double?,
    @SerialName("generationtime_ms")
    val generationTimeMilliSeconds: Double?,
    val latitude: Double?,
    val longitude: Double?,
    val timezone: String?,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)