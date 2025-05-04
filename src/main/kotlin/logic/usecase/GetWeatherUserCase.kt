package logic.usecase

import data.dto.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetWeatherUserCase(
    private val repository: WeatherRepository,
    private val validator: WeatherValidator = WeatherValidator()
) {
    suspend fun getWeather(latLong: LatLong): CurrentWeather {
        validator.validate(repository.fetchWeather(latLong))
        return repository.fetchWeather(latLong)
    }
}