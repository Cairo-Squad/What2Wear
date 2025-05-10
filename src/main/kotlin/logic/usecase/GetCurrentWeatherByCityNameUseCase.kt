package logic.usecase

import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetCurrentWeatherByCityNameUseCase(
    private val repository: WeatherRepository
) {
    suspend fun getCurrentWeather(cityName: String): CurrentWeather {
        val cityLocation = repository.getCityLocationByName(cityName)
        return repository.getWeatherFromRemote(cityLocation)
    }
}