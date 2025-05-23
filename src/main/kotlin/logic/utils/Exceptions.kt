package logic.utils

open class WeatherException(message: String) : Exception(message)
class NetworkException : WeatherException("Network unavailable! Please check your network.")
class FetchingWeatherException : WeatherException("Can't fetch this city's weather! Please try again.")
class UnexpectedErrorException : WeatherException("Unexpected error happened! Please try again.")
class NoClothesFoundException : WeatherException("No matching clothes found.")
