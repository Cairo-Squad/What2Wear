package ui

import di.*
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

fun main() {
    startKoin {
        modules(appModule, useCasesModule)
    }

    val clothsApp: ClothsApp = getKoin().get()
    clothsApp.start()
}