package ui.ioHandlers

class ConsoleUserInputHandler : UserInputHandler {

    override fun getUserInput(): String? {
        return readlnOrNull()
    }
}