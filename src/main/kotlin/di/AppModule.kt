package di

import data.datasource.RemoteDataSourceImpl
import data.repository.RemoteDataSource
import data.repository.WeatherRepositoryImpl
import logic.repository.WeatherRepository
import org.koin.dsl.module
import ui.ClothsApp
import ui.feature.*
import ui.ioHandlers.*

val appModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    single<UserInputHandler> { ConsoleUserInputHandler() }
    single<OutputHandler> { ConsoleOutputHandler() }
    single { ChooseCityFeatureUI(get(), get(), get()) }
    single { ClothsApp(get(), get()) }
}