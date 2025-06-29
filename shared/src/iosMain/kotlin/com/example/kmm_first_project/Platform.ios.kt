package com.example.kmm_first_project

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun getHttpClient() = HttpClient(Darwin) {
    engine {
        configureRequest {
            pipelining = true
        }
    }
}