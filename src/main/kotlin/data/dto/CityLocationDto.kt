package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityLocationResponse(
    val results: List<CityLocationDto>,
    @SerialName("generationtime_ms") val generationTimeMilliSeconds: Double
)

@Serializable
data class CityLocationDto(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val elevation: Double,
    @SerialName("feature_code") val featureCode: String,
    @SerialName("country_code") val countryCode: String,
    @SerialName("admin1_id") val admin1Id: Int,
    val timezone: String,
    val population: Int,
    @SerialName("country_id") val countryId: Int,
    val country: String,
    val admin1: String
)