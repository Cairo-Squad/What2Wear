package logic.usecase

import data.dto.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class GetWeatherUserCase(
    private val repository: WeatherRepository
) {
    suspend fun getWeather(latLong: LatLong): CurrentWeather {
        return repository.fetchWeather(latLong)
    }
}