package di

import data.datasource.RemoteDataSourceImpl
import data.datasource.SuggestionClothesDataSourceImpl
import data.repository.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import logic.repository.WeatherRepository
import org.koin.dsl.module
import ui.ClothsApp
import ui.feature.*
import ui.ioHandlers.*

val appModule = module {
    single { HttpClient(CIO) }
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<SuggestionClothesDataSource> { SuggestionClothesDataSourceImpl() }
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }

    single<UserInputHandler> { ConsoleUserInputHandler() }
    single<OutputHandler> { ConsoleOutputHandler() }
    single { WeatherSuggestionExecutor(get(), get(), get(), get()) }
    single { ChooseCityFeatureUI(get(), get(), get()) }
    single { EnterCityFeatureUI(get(), get(), get()) }
    single { ClothsApp(get(), get(), get(), get()) }
}