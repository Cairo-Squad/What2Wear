package logic.usecase

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat

class ClothingSuggestionTest {

    private val clothingSuggestion = ClothingSuggestion()

    @Test
    fun `test clothing suggestion for cold morning`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[0])
        assertThat(suggestion).isEqualTo("7:00 - 2.0°C: ❄️ Cold morning: Wear coat 🧥 and hat 👒")
    }

    @Test
    fun `test clothing suggestion for freezing night`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[1])
        assertThat(suggestion).isEqualTo("22:00 - -3.0°C: 🌙 Freezing night: Coat 🧥, scarf 🧣, gloves 🧤, and hat 👒")
    }

    @Test
    fun `test clothing suggestion for cool morning`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[2])
        assertThat(suggestion).isEqualTo("8:00 - 10.0°C: 🌤️ Cool morning: Jacket 🧥 Hoodie 👚 with boots 👢")
    }

    @Test
    fun `test clothing suggestion for cool night`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[3])
        assertThat(suggestion).isEqualTo("20:00 - 12.0°C: 🌙 Cold night: Hoodie 👚 and scarf 🧣")
    }

    @Test
    fun `test clothing suggestion for nice morning`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[4])
        assertThat(suggestion).isEqualTo("10:00 - 20.0°C: ☀️ Nice morning: Top 👚 and trousers 👖")
    }

    @Test
    fun `test clothing suggestion for warm night`() {
        val currentWeather = FakeData.allWeatherData
        val suggestion = clothingSuggestion.suggestClothes(currentWeather[5])
        assertThat(suggestion).isEqualTo("23:00 - 28.0°C: 🌙 Warm night: Wear a light dress 👗")
    }
}
