package data.datasource

import data.datasource.ApiConstants.WEATHER_BASE_URL
import data.dto.CityLocationDto
import data.dto.CityWeatherDto
import data.repository.RemoteDataSource
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import logic.model.CityLocation

class RemoteDataSourceImpl(
    private val ktorClient: HttpClient
) : RemoteDataSource {

    override suspend fun getCityLocationByName(cityName: String): CityLocationDto {
        // TODO: Should the parameters be constants? Or is it fine here to use them like this?
        val response = ktorClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = ApiConstants.GEOCODING_BASE_URL
                path(ApiConstants.SEARCH_CITY_LOCATION_ENDPOINT)
                parameter("name", cityName)
                parameter("count", "1")
            }
        }
        return Json.decodeFromString<CityLocationDto>(response.bodyAsText())
    }

    override suspend fun getWeatherByLocation(cityLocation: CityLocation): CityWeatherDto {
        val response = ktorClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = WEATHER_BASE_URL
                path(ApiConstants.GET_LOCATION_WEATHER_ENDPOINT)
                parameter("latitude", cityLocation.latitude)
                parameter("longitude", cityLocation.longitude)
                parameter("current_weather", "true")
            }
        }
        return Json.decodeFromString<CityWeatherDto>(response.bodyAsText())
    }
}