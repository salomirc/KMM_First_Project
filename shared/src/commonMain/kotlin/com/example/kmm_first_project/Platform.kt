package com.example.kmm_first_project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform