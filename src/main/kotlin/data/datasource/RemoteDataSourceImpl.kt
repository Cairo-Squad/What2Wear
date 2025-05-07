package data.datasource

import data.datasource.ApiConstants.WEATHER_BASE_URL
import data.dto.CityLocationResponse
import data.dto.CurrentWeatherResponse
import data.repository.RemoteDataSource
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import logic.model.LatLong

class RemoteDataSourceImpl(
    private val ktorClient: HttpClient
) : RemoteDataSource {

    override suspend fun getCityLocationByName(cityName: String): CityLocationResponse {
        val response = ktorClient.get("${ApiConstants.GEOCODING_BASE_URL}/search?name=$cityName&count=1")
        return Json.decodeFromString<CityLocationResponse>(response.bodyAsText())
    }

    override suspend fun getWeatherByLocation(latLong: LatLong): CurrentWeatherResponse {
        val response =
            ktorClient.get {
                url(WEATHER_BASE_URL)
                parameter("latitude", latLong.latitude)
                parameter("longitude", latLong.longitude)
                parameter("current_weather", "true")
            }
        return Json.decodeFromString<CurrentWeatherResponse>(response.bodyAsText())
    }
}