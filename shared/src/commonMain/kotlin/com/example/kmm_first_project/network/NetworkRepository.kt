package com.example.kmm_first_project.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class NetworkRepository() {

    private val httpClient = HttpClient()

    suspend fun getHelloList(): String{
        val response = httpClient.get(HELLO_LIST)
        return response.bodyAsText()
    }

    companion object {
        const val HELLO_LIST = "https://raw.githubusercontent.com/KaterinaPetrova/greeting/main/greetings.json"
    }
}