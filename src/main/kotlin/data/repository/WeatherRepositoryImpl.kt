package data.repository

import data.dto.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun fetchWeather(latLong: LatLong): CurrentWeather {
        return CurrentWeather(1.1,"",1)
    }

}