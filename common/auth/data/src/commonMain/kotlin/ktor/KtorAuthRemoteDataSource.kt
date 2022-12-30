package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ktor.model.KtorLoginRequest
import model.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun performLogin(request: KtorLoginRequest): Token {
        return httpClient.post("/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}