package data.repository.mapper

import data.dto.CurrentWeatherDTO
import logic.utils.TemperatureNotFoundException
import logic.utils.WeatherStateException
import kotlinx.datetime.LocalDateTime
import logic.model.CurrentWeather

// TODO: Refactor the nullability logic!!
fun CurrentWeatherDTO.toCurrentWeather(): CurrentWeather {
    val parsedTime = LocalDateTime.parse(
        time ?: throw IllegalArgumentException("Missing timestamp")
    ).time
    return CurrentWeather(
        temperature = this.temperature ?: throw TemperatureNotFoundException(),
        time = parsedTime,
        weatherCode = this.weatherCode ?: throw WeatherStateException()
    )
}