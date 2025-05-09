package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityWeatherDto(
    @SerialName("current_weather") val currentWeather: CurrentWeatherDTO? = null,
    @SerialName("current_weather_units") val currentWeatherUnits: CurrentWeatherUnitsDto? = null,
    @SerialName("elevation") val elevation: Double? = null,
    @SerialName("generationtime_ms") val generationTimeMilliSeconds: Double? = null,
    @SerialName("latitude") val latitude: Double? = null,
    @SerialName("longitude") val longitude: Double? = null,
    @SerialName("timezone") val timezone: String? = null,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String? = null,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int? = null
)