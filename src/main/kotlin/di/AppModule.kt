package di

import data.datasource.RemoteDataSourceImpl
import data.repository.RemoteDataSource
import data.repository.WeatherRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module
import ui.ClothsApp
import ui.feature.*
import ui.ioHandlers.*

val appModule = module {
    single { HttpClient(CIO) }
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    single<UserInputHandler> { ConsoleUserInputHandler() }
    single<OutputHandler> { ConsoleOutputHandler() }
    single { ChooseCityFeatureUI(get(), get(), get()) }
    single { ClothsApp(get(), get()) }
}