package data.repository

import data.repository.mapper.toCurrentWeather
import data.utils.NetworkException
import kotlinx.datetime.LocalTime
import logic.model.LatLong
import logic.model.CurrentWeather
import logic.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): WeatherRepository {
    override suspend fun getWeatherFromRemote(latLong: LatLong): CurrentWeather {
        return remoteDataSource.getWeatherByLocation(latLong).currentWeather?.toCurrentWeather()
            ?: throw NetworkException()
    }
}