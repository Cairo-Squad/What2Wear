package data.repository

import data.repository.mapper.toCityLocation
import logic.model.CityLocation
import logic.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return remoteDataSource.getCityLocationByName(cityName).toCityLocation()
    }
}