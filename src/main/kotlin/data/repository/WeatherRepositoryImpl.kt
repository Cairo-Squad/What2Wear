package data.repository

import logic.model.LatLong
import logic.model.CurrentWeather
import logic.model.CityLocation
import logic.repository.WeatherRepository
import data.repository.mapper.toCityLocation
import data.repository.mapper.toCurrentWeather
import logic.utils.NetworkException

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): WeatherRepository {

    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return remoteDataSource.getCityLocationByName(cityName).toCityLocation()
    }

    override suspend fun getWeatherFromRemote(latLong: LatLong): CurrentWeather {
        return remoteDataSource.getWeatherByLocation(latLong).currentWeather?.toCurrentWeather()
            ?: throw NetworkException()

    }
}