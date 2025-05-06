package logic.usecase

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat
import logic.model.CurrentWeather
import java.time.LocalTime

class ClothingSuggestionUseCaseTest {

    private val clothingSuggestion = ClothingSuggestionUseCase()

    @Test
    fun `should suggestt clothes for cold morning when temperature is cold`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 2.0, time = LocalTime.of(7, 0), weatherCode = 1)

        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("7:00 - 2.0°C: ❄️ Cold morning: Wear coat 🧥 and hat 👒")
    }

    @Test
    fun `should suggest clothes for freezing night when temperature is Freezing `() {
        // Given
        val currentWeather = CurrentWeather(temperature = -3.0, time = LocalTime.of(22, 0), weatherCode = 2)


        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("22:00 - -3.0°C: 🌙 Freezing night: Coat 🧥, scarf 🧣, gloves 🧤, and hat 👒")
    }

    @Test
    fun `should suggest clothes for cool morning when temperature is  cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 10.0, time = LocalTime.of(8, 0), weatherCode = 3)


        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("8:00 - 10.0°C: 🌤️ Cool morning: Jacket 🧥 Hoodie 👚 with boots 👢")
    }

    @Test
    fun `should suggest clothes for cold night when temperature is cool`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 12.0, time = LocalTime.of(20, 0), weatherCode = 4)


        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("20:00 - 12.0°C: 🌙 Cold night: Hoodie 👚 and scarf 🧣")
    }

    @Test
    fun `should suggest clothes for nice morning when temperature is sunny`() {
        // Given
        val currentWeather = CurrentWeather(temperature = 20.0, time = LocalTime.of(10, 0), weatherCode = 5)


        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("10:00 - 20.0°C: ☀️ Nice morning: Top 👚 and trousers 👖")
    }

    @Test
    fun `should suggest clothes for warm night when temperature is hot  `() {
        // Given
        val currentWeather = CurrentWeather(temperature = 28.0, time = LocalTime.of(23, 0), weatherCode = 6)


        // When
        val suggestion = clothingSuggestion.suggestClothes(currentWeather)

        // Then
        assertThat(suggestion).isEqualTo("23:00 - 28.0°C: 🌙 Warm night: Wear a light dress 👗")
    }
}
