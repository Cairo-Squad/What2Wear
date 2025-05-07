package logic.repository

import logic.model.LatLong
import logic.model.CurrentWeather
import logic.model.CityLocation

interface WeatherRepository {
    suspend fun getCityLocationByName(cityName: String): CityLocation
    suspend fun getWeatherFromRemote(latLong: LatLong): CurrentWeather
}