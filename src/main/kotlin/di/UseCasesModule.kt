package di

import logic.usecase.GetCityLocationByNameUseCase
import logic.usecase.GetWeatherUserCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetCityLocationByNameUseCase(get()) }
    single { GetWeatherUserCase(get()) }
}