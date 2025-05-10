package di

import logic.usecase.ClothingSuggestionUseCase
import logic.usecase.GetCurrentWeatherByCityNameUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetCurrentWeatherByCityNameUseCase(get()) }
    single { ClothingSuggestionUseCase(get()) }
}