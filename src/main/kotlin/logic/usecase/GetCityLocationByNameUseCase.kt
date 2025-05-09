package logic.usecase

import logic.model.CityLocation
import logic.repository.WeatherRepository

class GetCityLocationByNameUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun getCityLocation(cityName: String): CityLocation {
        return weatherRepository.getCityLocationByName(cityName)
    }
}