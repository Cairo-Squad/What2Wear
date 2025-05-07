package di

import data.datasource.RemoteDataSourceImpl
import data.repository.WeatherRepositoryImpl
import data.repository.RemoteDataSource
import org.koin.dsl.module

val appModule = module {
    single { RemoteDataSourceImpl() }
    single { WeatherRepositoryImpl(get()) }
    single<RemoteDataSource> { RemoteDataSourceImpl() }
}