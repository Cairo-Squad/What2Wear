package di

import data.datasource.RemoteDataSourceImpl
import data.repository.WeatherRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

val appModule = module {
    single { HttpClient(CIO) }
    single { RemoteDataSourceImpl(get()) }
    single { WeatherRepositoryImpl(get()) }
}