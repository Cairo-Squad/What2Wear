package logic.usecase

import data.utils.TemperatureException
import data.utils.WeatherStateException
import logic.model.CurrentWeather

class WeatherValidator {
    private val validWMOCodes = setOf(0,1,2,3,45,48,51,53,55,56,57,61,63,65,66,67,71,73,75,77,80,81,82,85,86,95,96,99)

    fun validate(currentWeather: CurrentWeather) {
        validateTemperature(currentWeather.temperature)
        validateWeatherCode(currentWeather.weatherCode)
    }

    private fun validateTemperature(temp: Double) {
        if (temp < -89.2 || temp > 60)
            throw TemperatureException()
    }

    private fun validateWeatherCode(code: Int) {
        if (code !in validWMOCodes) throw WeatherStateException()
    }
}
