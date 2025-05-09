package ui.utils

import logic.model.SuggestionClothes

fun SuggestionClothes.getPrintableString(): String {
    return """
        🕛 Time: ${this.hour}:00
        🌡️ Temperature: ${this.temperature}°C
        👕 Clothes Suggestions: ${this.suggestionClothes.joinToString(", ")}
    """.trimIndent()
}