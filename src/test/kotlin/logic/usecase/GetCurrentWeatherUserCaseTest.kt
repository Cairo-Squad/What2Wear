package logic.usecase

import com.google.common.truth.Truth.assertThat
import logic.utils.NetworkException
import logic.model.CityLocation
import logic.utils.WeatherStateException
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalTime
import logic.model.CurrentWeather
import logic.repository.WeatherRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GetCurrentWeatherUseCaseTest {

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var getCurrentWeatherUseCase: GetCurrentWeatherUseCase

    @BeforeEach
    fun setUp() {
        weatherRepository = mockk()
        getCurrentWeatherUseCase = GetCurrentWeatherUseCase(weatherRepository)
    }

    @Test
    fun `should return current weather, when valid coordinates`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 22.5, time = LocalTime(12, 0), weatherCode = 3)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When
        val result = getCurrentWeatherUseCase.getCurrentWeather(CityLocation(51.5, -0.1))

        // Then
        assertThat(result).isEqualTo(weather)
    }

    @Test
    fun `should throw NetworkException, when repository fails`() = runTest {
        // Given
        coEvery { weatherRepository.getWeatherFromRemote(any()) } throws NetworkException()

        // When & Then
        assertThrows<NetworkException> {
            getCurrentWeatherUseCase.getCurrentWeather(CityLocation(99.0, 12.2))
        }
    }

    @Test
    fun `should throws WeatherStateException, when weather code is out of range`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 44.5, time = LocalTime(12, 0), weatherCode = 1000)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When & Then
        assertThrows<WeatherStateException> {
            getCurrentWeatherUseCase.getCurrentWeather(CityLocation(51.5, -0.1))
        }
    }
}