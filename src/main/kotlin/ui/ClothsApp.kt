package ui

import ui.feature.ChooseCityFeatureUI
import ui.ioHandlers.OutputHandler

class ClothsApp(
    private val outputHandler: OutputHandler,
    private val chooseCityFeatureUI: ChooseCityFeatureUI
) {
    fun start() {
        outputHandler.printlnMessage(CliConstants.WELCOME_MESSAGE)
        chooseCityFeatureUI.execute()
    }
}