package com.example.kmm_first_project

import io.ktor.client.HttpClient

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect fun getHttpClient(): HttpClient