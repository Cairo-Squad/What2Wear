package data.utils

open class WeatherException(message: String) : Exception(message)
class TemperatureOutOfBoundException : WeatherException("Temperature should be between -90 to 60")
class WeatherStateException : WeatherException("There is no Weather State")
class TemperatureNotFoundException : WeatherException("There is no Temperature")
class NetworkException : Exception("Network unavailable")