package logic.usecase

import logic.model.CurrentWeather

class ClothingSuggestion {
    fun suggestClothes(current : CurrentWeather) : String {
        val hour = current.time.hour
        var timeOfDay = ""
        if (hour in 5..16) {
            timeOfDay = "morning"
        } else {
            timeOfDay = "night"
        }
        val temp = current.temperature

        val suggestion = when {
            temp < 5 -> if (timeOfDay == "morning")
                "❄️ Cold morning: Wear coat 🧥 and hat 👒"
            else
                "🌙 Freezing night: Coat 🧥, scarf 🧣, gloves 🧤, and hat 👒"

            temp < 15 -> if (timeOfDay == "morning")
                "🌤️ Cool morning: Jacket 🧥 Hoodie 👚 with boots 👢"
            else
                "🌙 Cold night: Hoodie 👚 and scarf 🧣"

            temp < 25 -> if (timeOfDay == "morning")
                "☀️ Nice morning: Top 👚 and trousers 👖"
            else
                "🌙 Mild night: Hoodie  👚 and trousers 👖"

            else -> if (timeOfDay == "morning")
                "🔥 Hot morning: Wear a dress 👗"
            else
                "🌙 Warm night: Wear a light dress 👗"
        }

        return "$hour:00 - ${temp}°C: $suggestion"
    }
}