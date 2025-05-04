package di

import data.datasource.RemoteDataSourceImpl
import data.repository.RemoteDataSource
import data.repository.WeatherRepositoryImpl
import logic.repository.WeatherRepository
import org.koin.dsl.module

val appModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}