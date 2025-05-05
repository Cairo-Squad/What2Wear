package logic.usecase

import logic.model.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetWeatherUserCase(
    private val repository: WeatherRepository,
    private val validator: WeatherValidator = WeatherValidator()
) {
    suspend fun getWeather(latLong: LatLong): CurrentWeather {
        val currentWeather = repository.fetchWeather(latLong)
        validator.validate(currentWeather)
        return currentWeather
    }
}