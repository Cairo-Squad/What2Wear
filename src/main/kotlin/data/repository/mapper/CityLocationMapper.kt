package data.repository.mapper

import data.dto.SingleCityLocationDto
import logic.model.CityLocation

fun SingleCityLocationDto.toCityLocation(): CityLocation {
    return CityLocation(
        latitude = this.latitude,
        longitude = this.longitude
    )
}