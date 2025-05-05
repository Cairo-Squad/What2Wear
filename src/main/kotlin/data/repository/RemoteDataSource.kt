package data.repository

import data.dto.CityLocationResponse

interface RemoteDataSource {
    suspend fun getCityLocationByName(cityName: String): CityLocationResponse
}