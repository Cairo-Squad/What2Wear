package data.repository

import logic.model.CityLocation
import logic.repository.WeatherRepository

class WeatherRepositoryImpl(
    val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return CityLocation(name = "Egypt", latitude = 0.0, longitude = 0.0)
    }
}