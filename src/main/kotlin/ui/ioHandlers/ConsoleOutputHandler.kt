package ui.ioHandlers

class ConsoleOutputHandler : OutputHandler {

    override fun printMessage(message: Any?) {
        print(message)
    }

    override fun printlnMessage(message: Any?) {
        println(message)
    }
}