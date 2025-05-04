package data.datasource

import data.repository.RemoteDataSource
import io.ktor.client.*
import io.ktor.client.engine.cio.*

class RemoteDataSourceImpl : RemoteDataSource {
    private val ktorClient = HttpClient(CIO)
}