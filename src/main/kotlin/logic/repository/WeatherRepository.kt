package logic.repository

import logic.model.CityLocation
import logic.model.CurrentWeather

interface WeatherRepository {
    suspend fun getCityLocationByName(cityName: String): CityLocation
    suspend fun getWeatherFromRemote(cityLocation: CityLocation): CurrentWeather
}