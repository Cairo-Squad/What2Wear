package ui.utils

import logic.model.SuggestedClothes

fun SuggestedClothes.getPrintableString(): String {
    return """
        🕛 Time: ${this.currentWeatherTimeHour}:00
        🌡️ Temperature: ${this.currentWeatherTemperature}°C
        👕 Clothes Suggestions: ${this.suggestionClothes?.joinToString(", ")}
    """.trimIndent()
}