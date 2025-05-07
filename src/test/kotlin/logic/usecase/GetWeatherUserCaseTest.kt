package logic.usecase

import com.google.common.truth.Truth.assertThat
import data.utils.NetworkException
import logic.model.LatLong
import data.utils.TemperatureOutOfBoundException
import data.utils.WeatherStateException
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalTime
import logic.model.CurrentWeather
import logic.repository.WeatherRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GetWeatherUserCaseTest {

    lateinit var weatherRepository: WeatherRepository
    lateinit var getWeatherUserCase: GetWeatherUserCase
    lateinit var validator : WeatherValidator

    @BeforeEach
    fun setUp() {
        weatherRepository = mockk()
        validator = WeatherValidator()
        getWeatherUserCase = GetWeatherUserCase(weatherRepository, validator)
    }

    @Test
    fun `should return current weather, when valid coordinates`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 22.5, time = LocalTime(12,0), weatherCode = 3)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When
        val result = getWeatherUserCase.getWeather(LatLong(51.5, -0.1))

        // Then
        assertThat(result).isEqualTo(weather)
    }

    @Test
    fun `should throw NetworkException, when repository fails`() = runTest {
        // Given
        coEvery { weatherRepository.getWeatherFromRemote(any()) } throws NetworkException()

        // When & Then
        assertThrows<NetworkException> {
            getWeatherUserCase.getWeather(LatLong(99.0, 12.2))
        }
    }

    @Test
    fun `should throws TemperatureException, when temp is out of range`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 999.5, time = LocalTime(12,0), weatherCode = 3)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When & Then
        assertThrows<TemperatureOutOfBoundException> {
            getWeatherUserCase.getWeather(LatLong(51.5, -0.1))
        }

    }

    @Test
    fun `should throws WeatherStateException, when weather code is out of range`() = runTest {
        // Given
        val weather = CurrentWeather(temperature = 44.5, time = LocalTime(12,0), weatherCode = 1000)

        coEvery { weatherRepository.getWeatherFromRemote(any()) } returns weather

        // When & Then
        assertThrows<WeatherStateException> {
            getWeatherUserCase.getWeather(LatLong(51.5, -0.1))
        }
    }
}