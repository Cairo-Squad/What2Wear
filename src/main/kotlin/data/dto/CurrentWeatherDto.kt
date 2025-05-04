package data.dto

data class CurrentWeatherDto(
    val interval: Int?,
    val isDay: Int?,
    val temperature: Double?,
    val time: String?,
    val weatherCode: Int?,
    val windDirection: Int?,
    val windSpeed: Double?
)