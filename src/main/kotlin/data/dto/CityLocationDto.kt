package data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityLocationDto(
    @SerialName("results") val cityLocationDtoList: List<SingleCityLocationDto>? = null,
    @SerialName("generationtime_ms") val generationTimeMilliSeconds: Double? = null
)

@Serializable
data class SingleCityLocationDto(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("latitude") val latitude: Double? = null,
    @SerialName("longitude") val longitude: Double? = null,
    @SerialName("elevation") val elevation: Double? = null,
    @SerialName("timezone") val timezone: String? = null,
    @SerialName("feature_code") val featureCode: String? = null,
    @SerialName("country_code") val countryCode: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("country_id") val countryId: Int? = null,
    @SerialName("population") val population: Int? = null,
    @SerialName("postcodes") val postcodes: List<String>? = null,
    @SerialName("admin1") val admin1: String? = null,
    @SerialName("admin2") val admin2: String? = null,
    @SerialName("admin3") val admin3: String? = null,
    @SerialName("admin4") val admin4: String? = null,
    @SerialName("admin1_id") val admin1Id: Int? = null,
    @SerialName("admin2_id") val admin2Id: Int? = null,
    @SerialName("admin3_id") val admin3Id: Int? = null,
    @SerialName("admin4_id") val admin4Id: Int? = null
)