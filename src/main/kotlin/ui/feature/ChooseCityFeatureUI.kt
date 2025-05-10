package ui.feature

import ui.CliConstants
import ui.ioHandlers.OutputHandler
import ui.ioHandlers.UserInputHandler

class ChooseCityFeatureUI(
    private val outputHandler: OutputHandler,
    private val userInputHandler: UserInputHandler,
    private val weatherSuggestionExecutor: WeatherSuggestionExecutor
) {
    private val cities = listOf(
        "Cairo",
        "Moscow",
        "London",
        "Rome",
        "Paris",
        "Beirut",
        "Seoul",
        "Tokyo",
        "Berlin",
        "Baghdad",
        "Beijing",
        "Damascus",
        "Qudus",
        "Vienna",
        "Amsterdam",
        "Stockholm",
        "Abu Dhabi",
        "Madrid",
        "Buenos Aires",
        "Athens"
    )

    fun execute() {
        outputHandler.printlnMessage()
        showAvailableCities()
        val selectedCityIndex = getCityNumberInput()
        weatherSuggestionExecutor.executeForCity(cities[selectedCityIndex])
    }

    private fun showAvailableCities() {
        outputHandler.printlnMessage(CliConstants.AVAILABLE_CITIES_MESSAGE)
        cities.forEachIndexed { index, city ->
            outputHandler.printMessage("${index + 1}- $city\t")
        }
        outputHandler.printlnMessage()
    }

    private fun getCityNumberInput(): Int {
        outputHandler.printMessage(CliConstants.ENTER_CITY_NUMBER_MESSAGE)
        while (true) {
            val userInput = userInputHandler.getUserInput()
            val parsedNumber = userInput?.toIntOrNull()
            if (parsedNumber == null || parsedNumber !in 1..cities.size) {
                outputHandler.printMessage(CliConstants.ENTER_VALID_CITY_NUMBER_MESSAGE)
            } else {
                return parsedNumber - 1
            }
        }
    }
}