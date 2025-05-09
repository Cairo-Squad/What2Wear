package logic.utils

import logic.model.CurrentWeather
import logic.usecase.WeatherConstants

object WeathersUtils {
    fun getTimeOfDay(currentWeather: CurrentWeather): String {
        val currentWeatherTimeHour = currentWeather.time.hour
        return if (currentWeatherTimeHour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) {
            WeatherConstants.MORNING
        } else {
            WeatherConstants.NIGHT
        }
    }

    fun getWeatherTag(currentWeather: CurrentWeather): String {
        val currentWeatherTemperature = currentWeather.temperature
        return when {
            currentWeatherTemperature < WeatherConstants.FREEZING_TEMP -> WeatherConstants.FREEZING_TAG
            currentWeatherTemperature < WeatherConstants.COLD_TEMP -> WeatherConstants.COLD_TAG
            currentWeatherTemperature < WeatherConstants.WARM_TEMP -> WeatherConstants.WARM_TAG
            else -> WeatherConstants.HOT_TAG
        }
    }
}