package logic.usecase

import logic.model.CurrentWeather

class ClothingSuggestionUseCase {
    fun suggestClothes(currentWeather : CurrentWeather) : String {
        val hour = currentWeather.time.hour
        val timeOfDay =
            if (hour in WeatherConstants.MORNING_START_HOUR..WeatherConstants.MORNING_END_HOUR) "morning" else "night"

        val temperature = currentWeather.temperature

        val suggestion = when {
            temperature < WeatherConstants.FREEZING_TEMP -> {
                if (timeOfDay == "morning") {
                    "❄️ Cold morning: Wear coat 🧥 and hat 👒"
                } else {
                    "🌙 Freezing night: Coat 🧥, scarf 🧣, gloves 🧤, and hat 👒"
                }
            }

            temperature < WeatherConstants.COLD_TEMP -> {
                if (timeOfDay == "morning") {
                    "🌤️ Cool morning: Jacket 🧥 Hoodie 👚 with boots 👢"

                } else {
                    "🌙 Cold night: Hoodie 👚 and scarf 🧣"
                }
            }

            temperature < WeatherConstants.WARM_TEMP -> {
                if (timeOfDay == "morning") {
                    "☀️ Nice morning: Top 👚 and trousers 👖"

                } else {
                    "🌙 Mild night: Hoodie  👚 and trousers 👖"
                }
            }

            else -> {
                if (timeOfDay == "morning") {
                    "🔥 Hot morning: Wear a dress 👗"

                } else {
                    "🌙 Warm night: Wear a light dress 👗"
                }
            }
        }
        return "$hour:00 - ${temperature}°C: $suggestion"
    }
}