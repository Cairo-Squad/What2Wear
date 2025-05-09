package logic.usecase

import logic.model.CurrentWeather
import logic.model.SuggestionClothes
import logic.repository.ClothingSuggestionRepository

class ClothingSuggestionUseCase(
    private val clothingSuggestionRepository : ClothingSuggestionRepository
) {
    fun suggestClothes(currentWeather : CurrentWeather) : SuggestionClothes {
        val hour = currentWeather.time.hour
        val timeOfDay =
            if (hour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) {
                WeatherConstants.MORNING
            } else {
                WeatherConstants.NIGHT
            }

        val temperature = currentWeather.temperature
        val weatherTag = when {
            temperature < WeatherConstants.FREEZING_TEMP -> WeatherConstants.FREEZING_TAG
            temperature < WeatherConstants.COLD_TEMP -> WeatherConstants.COLD_TAG
            temperature < WeatherConstants.WARM_TEMP -> WeatherConstants.WARM_TAG
            else -> WeatherConstants.HOT_TAG
        }

        val suggestion = filterClothes(listOf(weatherTag, timeOfDay))

        return SuggestionClothes(
            hour = hour,
            temperature = temperature,
            timeOfDay = timeOfDay,
            suggestionClothes = suggestion
        )
    }

    private fun filterClothes(tag : List<String>) : List<String> {
        return clothingSuggestionRepository.getAllClothes()
            .filter { clothes -> tag.all { tag -> clothes.tags.contains(tag.lowercase()) } }
            .map { it.name }
    }

}