package data.repository.mapper

import data.dto.CityLocationResponse
import logic.model.CityLocation

fun CityLocationResponse.toCityLocation(): CityLocation {
    return CityLocation(
        name = this.results[0].name,
        latitude = this.results[0].latitude,
        longitude = this.results[0].longitude
    )
}