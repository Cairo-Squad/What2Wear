package data.repository.mapper

import data.dto.CityLocationResponse
import logic.model.CityLocation

fun CityLocationResponse.toCityLocation(): CityLocation {
    val firstCityLocation = this.results.first()
    return CityLocation(
        name = firstCityLocation.name,
        latitude = firstCityLocation.latitude,
        longitude = firstCityLocation.longitude
    )
}