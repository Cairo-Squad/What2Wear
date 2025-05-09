package logic.usecase

import logic.model.CurrentWeather
import logic.model.SuggestionClothes
import logic.uitls.DataSource

class ClothingSuggestionUseCase {
    fun suggestClothes(currentWeather : CurrentWeather) : SuggestionClothes {
        val hour = currentWeather.time.hour
        val timeOfDay =
            if (hour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) "morning" else "night"

        val temperature = currentWeather.temperature
        val suggestion = when {
            temperature < WeatherConstants.FREEZING_TEMP ->
                filterClothes(listOf("FREEZING_TEMP", timeOfDay))

            temperature < WeatherConstants.COLD_TEMP ->
                filterClothes(listOf("COLD_TEMP", timeOfDay))

            temperature < WeatherConstants.WARM_TEMP ->
                filterClothes(listOf("WARM_TEMP", timeOfDay))

            else -> filterClothes(listOf("HOT_TEMP", timeOfDay))
        }

        return SuggestionClothes(
            hour = hour,
            temperature = temperature,
            timeOfDay = timeOfDay,
            suggestionClothes = suggestion
        )
    }

    private fun filterClothes(tag : List<String>) : List<String> {
        return DataSource.clothesSuggestion
            .filter { clothes -> tag.all { tag -> clothes.tags.contains(tag.lowercase()) } }
            .map { it.nameOfClothes }
    }

}