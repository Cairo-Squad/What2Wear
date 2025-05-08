package di

import logic.usecase.GetCityLocationByNameUseCase
import logic.usecase.GetCurrentWeatherUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetCityLocationByNameUseCase(get()) }
    single { GetCurrentWeatherUseCase(get()) }
}