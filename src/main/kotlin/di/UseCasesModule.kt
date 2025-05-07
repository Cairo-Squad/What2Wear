package di

import logic.usecase.GetCityLocationByNameUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetCityLocationByNameUseCase(get()) }
}