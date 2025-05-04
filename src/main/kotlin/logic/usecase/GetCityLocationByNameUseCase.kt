package logic.usecase

import logic.model.CityLocation
import logic.repository.WeatherRepository

class GetCityLocationByNameUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun execute(cityName: String): CityLocation {
        return CityLocation(name = "Egypt", latitude = 0.0, longitude = 0.0)
    }
}