package logic.usecase

import logic.model.CurrentWeather
import java.time.LocalTime

object FakeData {

    val allWeatherData = listOf(
        CurrentWeather(temperature = 2.0, time = LocalTime.of(7, 0), weatherCode = 1),
        CurrentWeather(temperature = -3.0, time = LocalTime.of(22, 0), weatherCode = 2),
        CurrentWeather(temperature = 10.0, time = LocalTime.of(8, 0), weatherCode = 3),
        CurrentWeather(temperature = 12.0, time = LocalTime.of(20, 0), weatherCode = 4),
        CurrentWeather(temperature = 20.0, time = LocalTime.of(10, 0), weatherCode = 5),
        CurrentWeather(temperature = 28.0, time = LocalTime.of(23, 0), weatherCode = 6)

    )
}