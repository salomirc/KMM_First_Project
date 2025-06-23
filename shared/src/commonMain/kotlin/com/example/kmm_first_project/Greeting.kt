package com.example.kmm_first_project

import com.example.kmm_first_project.network.NetworkRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn

class Greeting {
    private val platform: Platform = getPlatform()
    private val networkRepository = NetworkRepository(getHttpClient())

    suspend fun getHelloList(): String = networkRepository.getHelloList()

    fun greet(): String {
        return "Hello, ${platform.name} " +
                "There are only ${daysUntilNewYears()} days left until 🎅!\n"
    }

    private fun daysUntilNewYears(): Int {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val closestNewYear = LocalDate(
            year = today.year + 1,
            monthNumber = 1,
            dayOfMonth = 1
        )
        return today.daysUntil(closestNewYear)
    }
}