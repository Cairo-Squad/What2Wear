package logic.repository

import logic.model.LatLong
import logic.model.CurrentWeather

interface WeatherRepository {
    suspend fun fetchWeather(latLong: LatLong): CurrentWeather
}