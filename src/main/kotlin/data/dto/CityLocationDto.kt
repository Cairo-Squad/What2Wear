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
    val id: Int? = null,
    val name: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val elevation: Double? = null,
    @SerialName("feature_code") val featureCode: String? = null,
    @SerialName("country_code") val countryCode: String? = null,
    @SerialName("admin1_id") val admin1Id: Int? = null,
    val timezone: String? = null,
    val population: Int? = null,
    @SerialName("country_id") val countryId: Int? = null,
    val country: String? = null,
    val admin1: String? = null
)