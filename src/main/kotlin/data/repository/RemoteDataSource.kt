package data.repository

import data.dto.CurrentWeatherResponse
import logic.model.CityLocation
import data.dto.CityLocationDto

interface RemoteDataSource {
    suspend fun getWeatherByLocation(cityLocation: CityLocation): CurrentWeatherResponse
    suspend fun getCityLocationByName(cityName: String): CityLocationDto
}