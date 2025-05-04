package data.utils

open class WeatherException(message: String) : Exception(message)
class TemperatureException : WeatherException("Invalid Temperature")
class WeatherStateException : WeatherException("There is no Weather State")