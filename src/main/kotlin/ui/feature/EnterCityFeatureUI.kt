package ui.feature

import ui.CliConstants
import ui.ioHandlers.OutputHandler
import ui.ioHandlers.UserInputHandler

class EnterCityFeatureUI(
    private val outputHandler: OutputHandler,
    private val userInputHandler: UserInputHandler,
    private val weatherSuggestionExecutor: WeatherSuggestionExecutor
) {
    fun execute() {
        outputHandler.printlnMessage()
        weatherSuggestionExecutor.executeForCity(getCityNameInput())
    }

    private fun getCityNameInput(): String {
        outputHandler.printMessage(CliConstants.ENTER_CITY_NAME_MESSAGE)
        while (true) {
            val userInput = userInputHandler.getUserInput()
            if (userInput.isNullOrEmpty()) {
                outputHandler.printMessage(CliConstants.ENTER_VALID_CITY_NAME_MESSAGE)
            } else {
                return userInput
            }
        }
    }
}