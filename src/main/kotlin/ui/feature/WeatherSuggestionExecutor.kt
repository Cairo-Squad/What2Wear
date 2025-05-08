package ui.feature

import kotlinx.coroutines.runBlocking
import logic.usecase.ClothingSuggestionUseCase
import logic.usecase.GetCityLocationByNameUseCase
import logic.usecase.GetCurrentWeatherUseCase
import ui.CliConstants
import ui.ioHandlers.OutputHandler
import ui.utils.getPrintableString

class WeatherSuggestionExecutor(
    private val outputHandler: OutputHandler,
    private val getCityLocationByNameUseCase: GetCityLocationByNameUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val clothingSuggestionUseCase: ClothingSuggestionUseCase,
) {
    fun executeForCity(cityName: String) {
        outputHandler.printlnMessage(CliConstants.LOADING_MESSAGE)
        runBlocking {
            try {
                val cityLocation = getCityLocationByNameUseCase.getCityLocation(cityName)
                val cityCurrentWeather = getCurrentWeatherUseCase.getCurrentWeather(cityLocation)
                val suggestion = clothingSuggestionUseCase.suggestClothes(cityCurrentWeather)
                outputHandler.printlnMessage()
                outputHandler.printlnMessage(CliConstants.SUGGESTION_TITLE)
                outputHandler.printlnMessage(suggestion.getPrintableString())
            } catch (exception: Exception) {
                outputHandler.printlnMessage(CliConstants.UNEXPECTED_ERROR_MESSAGE)
            }
        }
    }
}