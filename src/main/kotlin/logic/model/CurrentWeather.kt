package logic.model

data class CurrentWeather(
    val temperature: Double,
    val time: String,
    val weatherCode: Int,
)