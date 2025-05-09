package data.repository

import data.dto.CityWeatherDto
import logic.model.CityLocation
import data.dto.CityLocationDto

interface RemoteDataSource {
    suspend fun getWeatherByLocation(cityLocation: CityLocation): CityWeatherDto
    suspend fun getCityLocationByName(cityName: String): CityLocationDto
}