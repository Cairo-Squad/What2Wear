package ui.ioHandlers

interface OutputHandler {
    fun printMessage(message: Any?)
    fun printlnMessage(message: Any?)
    fun printlnMessage()
}