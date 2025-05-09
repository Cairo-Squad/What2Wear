package logic.utils

open class WeatherException(message: String) : Exception(message)
class WeatherStateException : WeatherException("There is no Weather State")
class TemperatureNotFoundException : WeatherException("There is no Temperature")
class NetworkException : Exception("Network unavailable")