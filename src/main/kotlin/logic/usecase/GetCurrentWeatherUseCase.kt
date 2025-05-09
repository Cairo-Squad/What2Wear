package logic.usecase

import logic.model.CityLocation
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetCurrentWeatherUseCase(
    private val repository: WeatherRepository,
    private val validator: WeatherValidator = WeatherValidator()
) {
    suspend fun getCurrentWeather(cityLocation: CityLocation): CurrentWeather {
        val currentWeather = repository.getWeatherFromRemote(cityLocation)
        validator.validate(currentWeather)
        return currentWeather
    }
}