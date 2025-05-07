package logic.usecase

import logic.model.CurrentWeather
import logic.model.SuggestionClothes

class ClothingSuggestionUseCase {
    fun suggestClothes(currentWeather : CurrentWeather) : SuggestionClothes {
        val hour = currentWeather.time.hour
        val timeOfDay =
            if (hour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) "morning" else "night"

        val temperature = currentWeather.temperature

        val suggestion = when {
            temperature < WeatherConstants.FREEZING_TEMP -> {
                if (timeOfDay == "morning") {
                    listOf("Coat 🧥", "Hat 👒")
                } else {
                    listOf("Coat 🧥", "Scarf 🧣", "Gloves 🧤", "Hat 👒")
                }
            }

            temperature < WeatherConstants.COLD_TEMP -> {
                if (timeOfDay == "morning") {
                    listOf("Jacket 🧥", "Hoodie 👚", "Boots 👢")

                } else {
                    listOf("Hoodie 👚", "Scarf 🧣")
                }
            }

            temperature < WeatherConstants.WARM_TEMP -> {
                if (timeOfDay == "morning") {
                    listOf("Top 👚", "Trousers 👖")

                } else {
                    listOf("Hoodie 👚", "Trousers 👖")
                }
            }

            else -> {
                if (timeOfDay == "morning") {
                    listOf("Dress 👗")

                } else {
                    listOf("Light Dress 👗")
                }
            }
        }
        return SuggestionClothes(
            hour = hour,
            temperature = temperature,
            timeOfDay = timeOfDay,
            suggestionClothes = suggestion
        )
    }
}