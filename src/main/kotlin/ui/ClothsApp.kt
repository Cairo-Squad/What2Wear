package ui

import ui.feature.ChooseCityFeatureUI
import ui.feature.EnterCityFeatureUI
import ui.ioHandlers.OutputHandler
import ui.ioHandlers.UserInputHandler
import kotlin.system.exitProcess

class ClothsApp(
    private val outputHandler: OutputHandler,
    private val userInputHandler: UserInputHandler,
    private val chooseCityFeatureUI: ChooseCityFeatureUI,
    private val enterCityFeatureUI: EnterCityFeatureUI
) {
    fun start() {
        outputHandler.printlnMessage(CliConstants.WELCOME_MESSAGE)
        while (true) {
            outputHandler.printlnMessage(CliConstants.MAIN_MENU_TEXT)
            when (getUserChoiceNumberInput()) {
                1 -> chooseCityFeatureUI.execute()
                2 -> enterCityFeatureUI.execute()
                3 -> {
                    outputHandler.printlnMessage(CliConstants.SEPARATOR)
                    outputHandler.printlnMessage(CliConstants.EXIT_MESSAGE)
                    exitProcess(0)
                }
            }
            outputHandler.printlnMessage(CliConstants.SEPARATOR)
        }
    }

    private fun getUserChoiceNumberInput(): Int {
        outputHandler.printMessage(CliConstants.ENTER_CHOICE_NUMBER)
        while (true) {
            val userInput = userInputHandler.getUserInput()
            val parsedChoiceNumber = userInput?.toIntOrNull()
            if (parsedChoiceNumber == null || parsedChoiceNumber !in 1..3) {
                outputHandler.printMessage(CliConstants.ENTER_VALID_CHOICE_NUMBER_MESSAGE)
            } else {
                return parsedChoiceNumber
            }
        }
    }
}