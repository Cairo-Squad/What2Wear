package logic.utils

import logic.model.CurrentWeather
import logic.usecase.WeatherConstants

object WeathersUtils {
    fun getTimeOfDayTag(currentWeatherTimeHour: Int?): String {
        return if (currentWeatherTimeHour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) {
            WeatherConstants.MORNING
        } else {
            WeatherConstants.NIGHT
        }
    }

    fun getTemperatureTag(currentWeatherTemperature: Double?): String {
        return when {
            currentWeatherTemperature == null -> WeatherConstants.UNKNOWN_TEMP_TAG
            currentWeatherTemperature < WeatherConstants.FREEZING_TEMP -> WeatherConstants.FREEZING_TAG
            currentWeatherTemperature < WeatherConstants.COLD_TEMP -> WeatherConstants.COLD_TAG
            currentWeatherTemperature < WeatherConstants.WARM_TEMP -> WeatherConstants.WARM_TAG
            else -> WeatherConstants.HOT_TAG
        }
    }
}