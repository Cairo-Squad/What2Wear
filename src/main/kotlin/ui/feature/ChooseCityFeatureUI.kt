package ui.feature

import kotlinx.coroutines.runBlocking
import logic.usecase.GetCityLocationByNameUseCase
import ui.CliConstants
import ui.ioHandlers.OutputHandler
import ui.ioHandlers.UserInputHandler

class ChooseCityFeatureUI(
    private val outputHandler: OutputHandler,
    private val userInputHandler: UserInputHandler,
    private val getCityLocationByNameUseCase: GetCityLocationByNameUseCase
) {
    private val cities = listOf("Cairo", "Moscow", "London", "Rome", "Paris")

    fun execute() {
        showAvailableCities()
        val selectedCityIndex = getCityNumberInput()
        outputHandler.printlnMessage(CliConstants.LOADING_MESSAGE)
        runBlocking {
            try {
                val cityLocation = getCityLocationByNameUseCase.getCityLocation(cities[selectedCityIndex])
                // TODO: 3. Use the city location to get the current weather state.
                // TODO: 4. Pass the weather state to the clothes suggester use case.
                // TODO: 5. Show the suggestion.
            } catch (exception: Exception) {
                outputHandler.printlnMessage(CliConstants.UNEXPECTED_ERROR_MESSAGE)
            }
        }
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
            val parsedAmount = userInput?.toIntOrNull()
            if (parsedAmount == null || parsedAmount !in 1..cities.size) {
                outputHandler.printMessage(CliConstants.ENTER_VALID_CITY_NUMBER_MESSAGE)
            } else {
                return parsedAmount - 1
            }
        }
    }
}