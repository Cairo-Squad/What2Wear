package logic.utils

import io.ktor.utils.io.errors.*
import kotlinx.serialization.SerializationException

suspend fun <T> wrapCallWithTry(call: suspend () -> T): T {
    try {
        return call()
    } catch (exception: IOException) {
        throw NetworkException()
    } catch (exception: NullPointerException) {
        throw FetchingWeatherException()
    } catch (exception: SerializationException) {
        throw FetchingWeatherException()
    } catch (exception: Exception) {
        throw UnexpectedErrorException()
    }
}