package logic.usecase

import logic.model.CityLocation
import logic.repository.WeatherRepository

class GetCityLocationByNameUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun execute(cityName: String): CityLocation {
        if (cityName.isBlank()) {
            throw IllegalArgumentException("Please enter a valid city name!")
        }

        return weatherRepository.getCityLocationByName(cityName)
    }
}