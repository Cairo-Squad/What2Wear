package data.repository

import data.dto.CurrentWeatherResponse
import logic.model.LatLong
import data.dto.CityLocationResponse

interface RemoteDataSource {
    suspend fun getWeatherByLocation(latLong: LatLong): CurrentWeatherResponse
    suspend fun getCityLocationByName(cityName: String): CityLocationResponse
}