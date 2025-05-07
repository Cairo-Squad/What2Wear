package data.repository.mapper

import data.dto.CurrentWeatherDTO
import data.utils.TemperatureNotFoundException
import data.utils.WeatherStateException
import kotlinx.datetime.LocalDateTime
import logic.model.CurrentWeather

fun CurrentWeatherDTO.toCurrentWeather(): CurrentWeather {
    val parsedTime = LocalDateTime.parse(
        time ?: throw IllegalArgumentException("Missing timestamp"),
    ).time
    return CurrentWeather(
        temperature = this.temperature ?: throw TemperatureNotFoundException(),
        time = parsedTime,
        weatherCode = this.weathercode ?: throw WeatherStateException()
    )
}