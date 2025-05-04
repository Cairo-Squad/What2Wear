package logic.repository

import data.dto.LatLong
import logic.model.CurrentWeather

interface WeatherRepository {
    suspend fun fetchWeather(latLong: LatLong): CurrentWeather
}