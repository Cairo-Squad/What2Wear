package data.repository

import logic.model.CityLocation
import logic.model.CurrentWeather
import logic.repository.WeatherRepository
import data.repository.mapper.toCityLocation
import data.repository.mapper.toCurrentWeather
import logic.utils.NetworkException
import logic.utils.wrapCallWithTry

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return wrapCallWithTry { remoteDataSource.getCityLocationByName(cityName).toCityLocation() }
    }

    override suspend fun getWeatherFromRemote(cityLocation: CityLocation): CurrentWeather {
        return wrapCallWithTry {
            remoteDataSource.getWeatherByLocation(cityLocation).currentWeather?.toCurrentWeather()
                ?: throw NetworkException()
        }
    }
}