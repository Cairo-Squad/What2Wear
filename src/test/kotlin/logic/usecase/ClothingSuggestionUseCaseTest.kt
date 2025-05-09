package logic.usecase

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import kotlinx.datetime.LocalTime
import logic.model.Clothes
import logic.model.CurrentWeather
import logic.model.SuggestedClothes
import logic.repository.WeatherRepository
import logic.utils.WeathersUtils
import org.junit.jupiter.api.BeforeEach

class ClothingSuggestionUseCaseTest {

    private lateinit var weatherRepository : WeatherRepository
    private lateinit var clothingSuggestion : ClothingSuggestionUseCase
    private lateinit var weathersUtils : WeathersUtils

    @BeforeEach
    fun setup() {
        weatherRepository = mockk(relaxed = true)
        weathersUtils = mockk(relaxed = true)
        clothingSuggestion = ClothingSuggestionUseCase(weatherRepository)

    }

    @Test
    fun `should suggest clothes for cold morning when temperature is cold`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 2.0, time = LocalTime(7, 0), weatherCode = 1)
        every { weatherRepository.filterClothes(listOf("morning", "freezing_temp")) } returns listOf(
            "Coat 🧥",
            "Hat 👒"
        )

        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestedClothes(
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
        every { weatherRepository.filterClothes(listOf("night", "freezing_temp")) } returns listOf(
            "Coat 🧥",
            "Scarf 🧣",
            "Gloves 🧤"
        )

        // When
        val suggestionClothes = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestionClothes).isEqualTo(
            SuggestedClothes(
                hour = 22,
                temperature = -3.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Coat 🧥", "Scarf 🧣", "Gloves 🧤")
            )
        )
    }

    @Test
    fun `should suggest clothes for cool morning when temperature is  cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 10.0, time = LocalTime(8, 0), weatherCode = 3)
        every { weatherRepository.filterClothes(listOf("morning", "cold_temp")) } returns listOf(
            "Hat 👒",
            "Jacket 🧥",
            "Hoodie 👚",
            "Boots 👢"
        )


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestedClothes(
                hour = 8,
                temperature = 10.0,
                timeOfDay = "morning",
                suggestionClothes = listOf("Hat 👒", "Jacket 🧥", "Hoodie 👚", "Boots 👢")
            )
        )
    }

    @Test
    fun `should suggest clothes for cold night when temperature is cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 12.0, time = LocalTime(20, 0), weatherCode = 4)
        every { weatherRepository.filterClothes(listOf("night", "cold_temp")) } returns listOf(
            "Scarf 🧣",
            "Hoodie 👚"
        )


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestedClothes(
                hour = 20,
                temperature = 12.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Scarf 🧣", "Hoodie 👚")
            )
        )
    }

    @Test
    fun `should suggest clothes for nice morning when temperature is sunny`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 20.0, time = LocalTime(10, 0), weatherCode = 5)
        every { weatherRepository.filterClothes(listOf("morning", "warm_temp")) } returns listOf(
            "Hoodie 👚",
            "Top 👚",
            "T-Shirt 👕",
            "Shorts 🩳"
        )


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestedClothes(
                hour = 10,
                temperature = 20.0,
                timeOfDay = "morning",
                suggestionClothes = listOf("Hoodie 👚", "Top 👚", "T-Shirt 👕", "Shorts 🩳")
            )
        )
    }

    @Test
    fun `should suggest clothes for warm night when temperature is hot  `() {
        // Given
        val currentWeather = CurrentWeather(temperature = 28.0, time = LocalTime(23, 0), weatherCode = 6)
        every { weatherRepository.filterClothes(listOf("night", "hot_temp")) } returns listOf(
            "Light Dress 👗",
            "T-Shirt 👕"
        )


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestedClothes(
                hour = 23,
                temperature = 28.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Light Dress 👗", "T-Shirt 👕")
            )
        )
    }

}
