package data.repository

import kotlinx.datetime.LocalTime
import logic.model.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun fetchWeather(latLong: LatLong): CurrentWeather {
        return CurrentWeather(1.1, LocalTime(12,0),1)
    }

}