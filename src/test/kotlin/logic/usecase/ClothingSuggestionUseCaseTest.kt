package logic.usecase

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import logic.model.Clothes
import logic.model.CurrentWeather
import logic.model.SuggestionClothes
import logic.repository.ClothingSuggestionRepository
import org.junit.jupiter.api.BeforeEach
import java.time.LocalTime

class ClothingSuggestionUseCaseTest {

    private lateinit var clothingSuggestionRepository : ClothingSuggestionRepository
    private lateinit var clothingSuggestion : ClothingSuggestionUseCase

    @BeforeEach
    fun setup() {
        clothingSuggestionRepository = mockk(relaxed = true)
        clothingSuggestion = ClothingSuggestionUseCase(clothingSuggestionRepository)
    }

    @Test
    fun `should suggestt clothes for cold morning when temperature is cold`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 2.0, time = LocalTime.of(7, 0), weatherCode = 1)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes

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
        val currentWeather = CurrentWeather(temperature = -3.0, time = LocalTime.of(22, 0), weatherCode = 2)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes

        // When
        val suggestionClothes = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestionClothes).isEqualTo(
            SuggestionClothes(
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
        val currentWeather = CurrentWeather(temperature = 10.0, time = LocalTime.of(8, 0), weatherCode = 3)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
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
        val currentWeather = CurrentWeather(temperature = 12.0, time = LocalTime.of(20, 0), weatherCode = 4)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes


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
        val currentWeather = CurrentWeather(temperature = 20.0, time = LocalTime.of(10, 0), weatherCode = 5)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
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
        val currentWeather = CurrentWeather(temperature = 28.0, time = LocalTime.of(23, 0), weatherCode = 6)
        every { clothingSuggestionRepository.getAllClothes() } returns mockClothes


        // When
        val clothingSuggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(clothingSuggestion).isEqualTo(
            SuggestionClothes(
                hour = 23,
                temperature = 28.0,
                timeOfDay = "night",
                suggestionClothes = listOf("Light Dress 👗", "T-Shirt 👕")
            )
        )
    }

    val mockClothes = listOf(
        Clothes(name = "Coat 🧥", tags = listOf("freezing_temp", "morning", "night")),
        Clothes(name = "Scarf 🧣", tags = listOf("freezing_temp", "cold_temp", "night")),
        Clothes(name = "Gloves 🧤", tags = listOf("freezing_temp", "night")),
        Clothes(name = "Hat 👒", tags = listOf("freezing_temp", "cold_temp", "morning")),
        Clothes(name = "Jacket 🧥", tags = listOf("cold_temp", "morning")),
        Clothes(name = "Hoodie 👚", tags = listOf("cold_temp", "warm_temp", "morning", "night")),
        Clothes(name = "Boots 👢", tags = listOf("cold_temp", "morning")),
        Clothes(name = "Top 👚", tags = listOf("warm_temp", "morning")),
        Clothes(name = "Trousers 👖", tags = listOf("warm_temp", "night")),
        Clothes(name = "Dress 👗", tags = listOf("hot_temp", "morning")),
        Clothes(name = "Light Dress 👗", tags = listOf("hot_temp", "night")),
        Clothes(name = "T-Shirt 👕", tags = listOf("hot_temp", "warm_temp", "morning", "night")),
        Clothes(name = "Shorts 🩳", tags = listOf("hot_temp", "warm_temp", "morning"))
    )
}
