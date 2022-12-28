package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ktor.model.KtorSearchGame
import ktor.model.KtorSearchRequest

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post("/games/search") {
            contentType(ContentType.Application.Json)
            header("Bearer-Authorization", "bf8487ae-7d47-11ec-90d6-0242ac120003")
            setBody(KtorSearchRequest(""))
        }.body()
    }

    suspend fun searchGame(query: String): List<KtorSearchGame> {
        return httpClient.post("/games/search") {
            contentType(ContentType.Application.Json)
            header("Bearer-Authorization", "bf8487ae-7d47-11ec-90d6-0242ac120003")
            setBody(KtorSearchRequest(query))
        }.body()
    }
}