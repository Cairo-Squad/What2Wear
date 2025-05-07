package data.repository

import kotlinx.datetime.LocalTime
import logic.model.LatLong
import logic.model.CurrentWeather
import logic.model.CityLocation
import logic.repository.WeatherRepository
import data.repository.mapper.toCityLocation

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {
    override suspend fun fetchWeather(latLong: LatLong): CurrentWeather {
        return CurrentWeather(1.1, LocalTime(12,0),1)
    }
    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return remoteDataSource.getCityLocationByName(cityName).toCityLocation()
    }
}