package logic.usecase

import logic.model.CityLocation
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetCurrentWeatherUseCase(
    private val repository: WeatherRepository
) {
    suspend fun getCurrentWeather(cityLocation: CityLocation): CurrentWeather {
        return repository.getWeatherFromRemote(cityLocation)
    }
}