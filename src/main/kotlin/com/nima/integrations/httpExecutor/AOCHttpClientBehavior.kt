package com.nima.integrations.httpExecutor

import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class AOCHttpClientBehavior : HttpClientExecutor {
    private val client = HttpClient.newBuilder().build()
    private val baseURI:String = "https://adventofcode.com/"

    override fun makeSecureRequest(path: String, session: String): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseURI}${path}"))
            .header("cookie", session)
            .build()
        return client.send(request,HttpResponse.BodyHandlers.ofString())
    }

    override fun makeRequest(path: String): HttpResponse<String> {
        TODO("Not yet implemented")
    }

}