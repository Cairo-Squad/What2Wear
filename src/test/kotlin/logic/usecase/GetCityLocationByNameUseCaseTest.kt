package logic.usecase

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import logic.model.CityLocation
import logic.repository.WeatherRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GetCityLocationByNameUseCaseTest {

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var getCityLocationByNameUseCase: GetCityLocationByNameUseCase

    @BeforeEach
    fun setup() {
        weatherRepository = mockk(relaxed = true)
        getCityLocationByNameUseCase = GetCityLocationByNameUseCase(weatherRepository)
    }

    @Test
    fun `should throw an exception when the repository throws an exception`() {
        runTest {
            // Given
            coEvery { weatherRepository.getCityLocationByName(any()) } throws Exception()

            // When, Then
            assertThrows<Exception> {
                getCityLocationByNameUseCase.execute("Egypt")
            }
        }
    }

    @Test
    fun `should throw an IllegalArgumentException when the given city name is invalid`() {
        runTest {
            // Given, When, Then
            assertThrows<IllegalArgumentException> {
                getCityLocationByNameUseCase.execute(" ")
            }
        }
    }

    @Test
    fun `should return the location data of the city when given a valid city name`() {
        runTest {
            // Given
            coEvery { weatherRepository.getCityLocationByName(any()) } returns getValidCityLocation()

            // When
            val result = getCityLocationByNameUseCase.execute("Cairo")

            // Then
            assertThat(result).isEqualTo(getValidCityLocation())
        }
    }

    private fun getValidCityLocation(): CityLocation {
        return CityLocation(
            name = "Cairo",
            latitude = 0.0,
            longitude = 0.0
        )
    }
}