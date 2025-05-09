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

        val currentWeatherTimeOfDayTag = WeathersUtils.getTimeOfDay(currentWeather)
        val temperatureTag= WeathersUtils.getWeatherTag(currentWeather)

        weatherTag.add(currentWeatherTimeOfDayTag)
        weatherTag.add(temperatureTag)

        val suggestedClothes= weatherRepository.filterClothes(weatherTag)

        return SuggestedClothes(
            hour = currentWeather.time.hour,
            temperature = currentWeather.temperature,
            timeOfDay = currentWeatherTimeOfDayTag,
            suggestionClothes = suggestedClothes
        )
    }
}