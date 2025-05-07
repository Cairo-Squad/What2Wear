package logic.usecase

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat
import kotlinx.datetime.LocalTime
import logic.model.CurrentWeather
import logic.model.SuggestionClothes
import org.junit.jupiter.api.BeforeEach

class ClothingSuggestionUseCaseTest {

    private lateinit var clothingSuggestion: ClothingSuggestionUseCase

    @BeforeEach
    fun setup() {
        clothingSuggestion = ClothingSuggestionUseCase()
    }

    @Test
    fun `should suggest clothes for cold morning when temperature is cold`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 2.0, time = LocalTime(7, 0), weatherCode = 1)

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 7,
                temperature = 2.0,
                timeOfDay = "morning",
                suggestionClothes = listOf("Coat 🧥", "Hat 👒")
            )
        )
    }

    @Test
    fun `should suggest clothes for freezing night when temperature is Freezing `() {
        // Given
        val currentWeather = CurrentWeather(temperature = -3.0, time = LocalTime(22, 0), weatherCode = 2)

        // When
        val suggestionClothes = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestionClothes).isEqualTo(
            SuggestionClothes(
                hour = 22,
                temperature = -3.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Coat 🧥", "Scarf 🧣", "Gloves 🧤", "Hat 👒")
            )
        )
    }

    @Test
    fun `should suggest clothes for cool morning when temperature is  cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 10.0, time = LocalTime(8, 0), weatherCode = 3)

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 8,
                temperature = 10.0,
                timeOfDay = "morning",
                suggestionClothes = listOf("Jacket 🧥", "Hoodie 👚", "Boots 👢")
            )
        )
    }

    @Test
    fun `should suggest clothes for cold night when temperature is cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 12.0, time = LocalTime(20, 0), weatherCode = 4)

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 20,
                temperature = 12.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Hoodie 👚", "Scarf 🧣")
            )
        )
    }

    @Test
    fun `should suggest clothes for nice morning when temperature is sunny`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 20.0, time = LocalTime(10, 0), weatherCode = 5)

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 10,
                temperature = 20.0,
                timeOfDay = "morning",
                suggestionClothes = listOf("Top 👚", "Trousers 👖")
            )
        )
    }

    @Test
    fun `should suggest clothes for warm night when temperature is hot  `() {
        // Given
        val currentWeather = CurrentWeather(temperature = 28.0, time = LocalTime(23, 0), weatherCode = 6)

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 23,
                temperature = 28.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Light Dress 👗")
            )
        )
    }
}
