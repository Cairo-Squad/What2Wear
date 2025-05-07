package logic.repository

import logic.model.LatLong
import logic.model.CurrentWeather
import logic.model.CityLocation

interface WeatherRepository {
    suspend fun fetchWeather(latLong: LatLong): CurrentWeather
    suspend fun getCityLocationByName(cityName: String): CityLocation
}