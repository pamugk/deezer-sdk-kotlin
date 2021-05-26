package api

import io.ktor.client.*
import io.ktor.client.features.json.*

class Deezer {
    private val httpClient = HttpClient {
        install(JsonFeature)
    }
}