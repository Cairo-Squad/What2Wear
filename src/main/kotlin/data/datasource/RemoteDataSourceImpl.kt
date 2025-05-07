package data.datasource

import data.datasource.ApiConstants.WEATHER_BASE_URL
import data.dto.CityLocationResponse
import data.dto.CurrentWeatherResponse
import data.repository.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import logic.model.LatLong

class RemoteDataSourceImpl(
    private val ktorClient: HttpClient
) : RemoteDataSource {

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

    override suspend fun getCityLocationByName(cityName: String): CityLocationResponse {
        TODO("Not yet implemented")
    }
}