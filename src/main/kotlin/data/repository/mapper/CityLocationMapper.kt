package data.repository.mapper

import data.dto.CityLocationDto
import logic.model.CityLocation

// TODO: Refactor the nullability logic!!
fun CityLocationDto.toCityLocation(): CityLocation {
    val firstCityLocation = this.cityLocationDtoList?.firstOrNull()
    return CityLocation(
        latitude = firstCityLocation?.latitude!!,
        longitude = firstCityLocation?.longitude!!
    )
}