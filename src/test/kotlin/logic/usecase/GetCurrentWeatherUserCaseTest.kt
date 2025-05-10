package logic.usecase

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalTime
import logic.model.CurrentWeather
import logic.repository.WeatherRepository
import logic.utils.FetchingWeatherException
import logic.utils.NetworkException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GetCurrentWeatherByCityNameUseCaseTest {

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var getCurrentWeatherUseCase: GetCurrentWeatherByCityNameUseCase

    @BeforeEach
    fun setUp() {
        weatherRepository = mockk(relaxed = true)
        getCurrentWeatherUseCase = GetCurrentWeatherByCityNameUseCase(weatherRepository)
    }

    @Test
    fun `should return current weather, when passed a valid city name`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 22.5, time = LocalTime(7, 0))
        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When
        val result = getCurrentWeatherUseCase.getCurrentWeather("Cairo")

        // Then
        assertThat(result).isEqualTo(weather)
    }

    @Test
    fun `should throw NetworkException, when the repository throws a NetworkException`() = runTest {
        // Given
        coEvery { weatherRepository.getWeatherFromRemote(any()) } throws NetworkException()

        // When & Then
        assertThrows<NetworkException> {
            getCurrentWeatherUseCase.getCurrentWeather("Cairo")
        }
    }

    @Test
    fun `should throw FetchingWeatherException, when the repository throws a FetchingWeatherException`() = runTest {
        // Given
        coEvery { weatherRepository.getWeatherFromRemote(any()) } throws FetchingWeatherException()

        // When & Then
        assertThrows<FetchingWeatherException> {
            getCurrentWeatherUseCase.getCurrentWeather("    ")
        }
    }
}