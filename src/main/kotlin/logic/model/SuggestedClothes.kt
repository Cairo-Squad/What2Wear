package logic.model

data class SuggestedClothes(
    val currentWeatherTimeHour : Int? = null,
    val currentWeatherTemperature :Double? = null,
    val currentWeatherTimeOfDay :String? = null,
    val suggestionClothes : List<String>? = null
)