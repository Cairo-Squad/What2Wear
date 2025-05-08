package logic.usecase

import com.google.common.truth.Truth.assertThat
import logic.utils.NetworkException
import logic.model.LatLong
import logic.utils.TemperatureOutOfBoundException
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
    private lateinit var validator: WeatherValidator

    @BeforeEach
    fun setUp() {
        weatherRepository = mockk()
        validator = WeatherValidator()
        getCurrentWeatherUseCase = GetCurrentWeatherUseCase(weatherRepository, validator)
    }

    @Test
    fun `should return current weather, when valid coordinates`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 22.5, time = LocalTime(12, 0), weatherCode = 3)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When
        val result = getCurrentWeatherUseCase.getCurrentWeather(LatLong(51.5, -0.1))

        // Then
        assertThat(result).isEqualTo(weather)
    }

    @Test
    fun `should throw NetworkException, when repository fails`() = runTest {
        // Given
        coEvery { weatherRepository.getWeatherFromRemote(any()) } throws NetworkException()

        // When & Then
        assertThrows<NetworkException> {
            getCurrentWeatherUseCase.getCurrentWeather(LatLong(99.0, 12.2))
        }
    }

    @Test
    fun `should throws TemperatureException, when temp is out of range`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 999.5, time = LocalTime(12, 0), weatherCode = 3)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When & Then
        assertThrows<TemperatureOutOfBoundException> {
            getCurrentWeatherUseCase.getCurrentWeather(LatLong(51.5, -0.1))
        }
    }

    @Test
    fun `should throws WeatherStateException, when weather code is out of range`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 44.5, time = LocalTime(12, 0), weatherCode = 1000)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When & Then
        assertThrows<WeatherStateException> {
            getCurrentWeatherUseCase.getCurrentWeather(LatLong(51.5, -0.1))
        }
    }
}