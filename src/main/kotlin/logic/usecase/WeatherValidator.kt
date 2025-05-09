package logic.usecase

import logic.utils.TemperatureOutOfBoundException
import logic.utils.WeatherStateException
import logic.Constants.ABSOLUTE_MAX_WEATHER
import logic.Constants.ABSOLUTE_MIN_WEATHER
import logic.model.CurrentWeather

class WeatherValidator {
    /**
     * WMO code represent the code which represent weather state e.g. Cloudy, Rainy..etc
    * */
    private val validWMOCodes = setOf(0,1,2,3,45,48,51,53,55,56,57,61,63,65,66,67,71,73,75,77,80,81,82,85,86,95,96,99)

    fun validate(currentWeather: CurrentWeather) {
        validateTemperature(currentWeather.temperature)
        validateWeatherCode(currentWeather.weatherCode)
    }

    private fun validateTemperature(temp: Double) {
        if (temp < ABSOLUTE_MIN_WEATHER || temp > ABSOLUTE_MAX_WEATHER)
            throw TemperatureOutOfBoundException()
    }

    private fun validateWeatherCode(code: Int) {
        if (code !in validWMOCodes) throw WeatherStateException()
    }
}
