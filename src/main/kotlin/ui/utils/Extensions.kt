package ui.utils

import logic.model.SuggestedClothes

fun SuggestedClothes.getPrintableString(): String {
    return """
        🕛 Time: ${this.hour}:00
        🌡️ Temperature: ${this.temperature}°C
        👕 Clothes Suggestions: ${this.suggestionClothes?.joinToString(", ")}
    """.trimIndent()
}