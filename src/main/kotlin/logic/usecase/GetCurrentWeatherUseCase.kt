package logic.usecase

import logic.model.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetCurrentWeatherUseCase(
    private val repository: WeatherRepository,
    private val validator: WeatherValidator = WeatherValidator()
) {
    suspend fun getCurrentWeather(latLong: LatLong): CurrentWeather {
        val currentWeather = repository.getWeatherFromRemote(latLong)
        validator.validate(currentWeather)
        return currentWeather
    }
}