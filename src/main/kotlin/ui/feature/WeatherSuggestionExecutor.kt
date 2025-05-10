package ui.feature

import kotlinx.coroutines.runBlocking
import logic.usecase.ClothingSuggestionUseCase
import logic.usecase.GetCurrentWeatherByCityNameUseCase
import logic.utils.*
import ui.CliConstants
import ui.ioHandlers.OutputHandler
import ui.utils.getPrintableString

class WeatherSuggestionExecutor(
    private val outputHandler: OutputHandler,
    private val getCurrentWeatherUseCase: GetCurrentWeatherByCityNameUseCase,
    private val clothingSuggestionUseCase: ClothingSuggestionUseCase,
) {
    fun executeForCity(cityName: String) {
        outputHandler.printlnMessage(CliConstants.LOADING_MESSAGE)
        runBlocking {
            try {
                val cityCurrentWeather = getCurrentWeatherUseCase.getCurrentWeather(cityName)
                val suggestion = clothingSuggestionUseCase.suggestClothes(cityCurrentWeather)
                outputHandler.printlnMessage()
                outputHandler.printlnMessage(CliConstants.SUGGESTION_TITLE)
                outputHandler.printlnMessage("${CliConstants.CITY_NAME_MESSAGE}$cityName")
                outputHandler.printlnMessage(suggestion.getPrintableString())
            } catch (exception: NetworkException) {
                outputHandler.printlnMessage(exception.message)
            } catch (exception: FetchingWeatherException) {
                outputHandler.printlnMessage(exception.message)
            } catch (exception: NoClothesFoundException) {
                outputHandler.printlnMessage(exception.message)
            } catch (exception: UnexpectedErrorException) {
                outputHandler.printlnMessage(exception.message)
            }
        }
    }
}