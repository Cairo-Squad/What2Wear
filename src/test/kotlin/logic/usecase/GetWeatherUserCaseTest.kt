package logic.usecase

import com.google.common.truth.Truth.assertThat
import data.dto.LatLong
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException

class GetWeatherUserCaseTest {

    lateinit var weatherRepository: WeatherRepository
    lateinit var getWeatherUserCase: GetWeatherUserCase

    @BeforeEach
    fun setUp() {
        weatherRepository = mockk()
        getWeatherUserCase = GetWeatherUserCase(weatherRepository)
    }

    @Test
    fun `should return current weather, when valid coordinates`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 22.5, time = "12", weatherCode = 3)

        coEvery { weatherRepository.fetchWeather(any()) } returns weather

        // When
        val result = getWeatherUserCase.getWeather(LatLong(51.5, -0.1))

        // Then
        assertThat(result).isEqualTo(weather)
    }

    @Test
    fun `should throw an exception, when repository fails`() = runTest {
        // Given
        coEvery { weatherRepository.fetchWeather(any()) } throws Exception()

        // When & Then
        assertThrows<Exception> {
            getWeatherUserCase.getWeather(LatLong(99.0, 12.2))
        }
    }
}