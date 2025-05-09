package data.repository

import logic.model.CityLocation
import logic.model.CurrentWeather
import logic.repository.WeatherRepository
import data.repository.mapper.toCityLocation
import data.repository.mapper.toCurrentWeather
import io.ktor.utils.io.errors.*
import kotlinx.serialization.SerializationException
import logic.utils.FetchingWeatherException
import logic.utils.NetworkException
import logic.utils.UnexpectedErrorException

class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getCityLocationByName(cityName: String): CityLocation {
        return wrapCallWithTry {
            remoteDataSource.getCityLocationByName(cityName).cityLocationDtoList?.firstOrNull()?.toCityLocation()
                ?: throw FetchingWeatherException()
        }
    }

    override suspend fun getWeatherFromRemote(cityLocation: CityLocation): CurrentWeather {
        return wrapCallWithTry {
            remoteDataSource.getWeatherByLocation(cityLocation).currentWeather?.toCurrentWeather()
                ?: throw FetchingWeatherException()
        }
    }

    private suspend fun <T> wrapCallWithTry(call: suspend () -> T): T {
        try {
            return call()
        } catch (exception: Exception) {
            throw when (exception) {
                is IOException -> NetworkException()
                is NullPointerException, is SerializationException, is FetchingWeatherException -> FetchingWeatherException()
                else -> UnexpectedErrorException()
            }
        }
    }
}