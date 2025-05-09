package data.repository.mapper

import data.dto.CurrentWeatherDTO
import kotlinx.datetime.LocalDateTime
import logic.model.CurrentWeather

fun CurrentWeatherDTO.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        temperature = this.temperature,
        time = LocalDateTime.parse(this.time ?: "").time,
        weatherCode = this.weatherCode
    )
}