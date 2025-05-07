package data.datasource

import data.dto.CityLocationResponse
import data.repository.RemoteDataSource
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl : RemoteDataSource {
    private val ktorClient = HttpClient(CIO)

    override suspend fun getCityLocationByName(cityName: String): CityLocationResponse {
        val response =
            ktorClient.get("https://geocoding-api.open-meteo.com/v1/search?name=$cityName&count=1&language=en&format=json")
        println(response.bodyAsText())
        return Json.decodeFromString<CityLocationResponse>(response.bodyAsText())
    }
}