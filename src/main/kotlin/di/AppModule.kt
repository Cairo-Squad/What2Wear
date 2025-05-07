package di

import data.datasource.RemoteDataSourceImpl
import data.repository.WeatherRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single { RemoteDataSourceImpl() }
    single { WeatherRepositoryImpl(get()) }
}