package com.example.kmm_first_project

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!\n" +
                "There are only ${daysUntilNewYears()} days left! 🎅"
    }

    fun daysUntilNewYears(): Int {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val closestNewYear = LocalDate(
            year = today.year + 1,
            monthNumber = 1,
            dayOfMonth = 1
        )
        return today.daysUntil(closestNewYear)
    }
}