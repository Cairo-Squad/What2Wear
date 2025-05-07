package data.repository

import data.dto.CurrentWeatherResponse
import logic.model.LatLong

interface RemoteDataSource {
    suspend fun getWeatherByLocation(latLong: LatLong): CurrentWeatherResponse
}