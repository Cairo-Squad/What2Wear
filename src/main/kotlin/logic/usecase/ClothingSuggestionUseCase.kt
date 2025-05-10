package logic.usecase

import logic.model.CurrentWeather
import logic.model.SuggestedClothes
import logic.repository.WeatherRepository
import logic.utils.WeathersUtils

class ClothingSuggestionUseCase(
    private val weatherRepository : WeatherRepository
) {
    fun suggestClothes(currentWeather : CurrentWeather) : SuggestedClothes {
        val weatherTag = mutableListOf<String>()

        val currentWeatherTimeOfDayTag = WeathersUtils.getTimeOfDayTag(currentWeather.time?.hour)
        val temperatureTag= WeathersUtils.getTemperatureTag(currentWeather.temperature)

        weatherTag.add(currentWeatherTimeOfDayTag)
        weatherTag.add(temperatureTag)

        val suggestedClothes= weatherRepository.filterClothes(weatherTag)

        return SuggestedClothes(
            currentWeatherTimeHour = currentWeather.time?.hour,
            currentWeatherTemperature = currentWeather.temperature,
            currentWeatherTimeOfDay = currentWeatherTimeOfDayTag,
            suggestionClothes = suggestedClothes
        )
    }
}