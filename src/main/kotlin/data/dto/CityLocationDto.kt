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
    val timezone: String? = null,
    @SerialName("feature_code") val featureCode: String? = null,
    @SerialName("country_code") val countryCode: String? = null,
    val country: String? = null,
    @SerialName("country_id") val countryId: Int? = null,
    val population: Int? = null,
    val postcodes: List<String>? = null,
    val admin1: String? = null,
    val admin2: String? = null,
    val admin3: String? = null,
    val admin4: String? = null,
    @SerialName("admin1_id") val admin1Id: Int? = null,
    @SerialName("admin2_id") val admin2Id: Int? = null,
    @SerialName("admin3_id") val admin3Id: Int? = null,
    @SerialName("admin4_id") val admin4Id: Int? = null
)