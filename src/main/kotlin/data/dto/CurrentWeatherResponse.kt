package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    @SerialName("current_weather")
    val currentWeather: CurrentWeatherDTO?,
    @SerialName("current_weather_units")
    val currentWeatherUnits: CurrentWeatherUnits?,
    @SerialName("elevation")
    val elevation: Double?,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)