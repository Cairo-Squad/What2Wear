package di

import logic.usecase.GetWeatherUserCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetWeatherUserCase(get()) }
}