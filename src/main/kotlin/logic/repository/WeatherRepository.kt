package logic.repository

import logic.model.CityLocation

interface WeatherRepository {
    suspend fun getCityLocationByName(cityName: String): CityLocation
}