package com.example.healthtracker.Screens

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale



object ExerciseRepository {
    private val runningMET = 8
    private val cyclingMET = 8.5
    private val hikingMET = 6

    fun getCaloriesForDate(date: String): CaloriesInfo {
        val runCal = runningMET * getMinForDate(date, "run")
        val cycleCal = cyclingMET * getMinForDate(date, "cycle")
        val hikeCal = hikingMET * getMinForDate(date, "hike")
        val totalCalories = runCal + cycleCal + hikeCal
        return CaloriesInfo(runCal, cycleCal, hikeCal, totalCalories)
    }

    fun getKmForDate(date: String, exerciseType: String): Int {
        return when (date) {
            getDate(-2) -> when (exerciseType) {
                "run" -> 5
                "cycle" -> 10
                "hike" -> 8
                else -> 0
            }
            getDate(-1) -> when (exerciseType) {
                "run" -> 6
                "cycle" -> 12
                "hike" -> 7
                else -> 0
            }
            getDate(0) -> when (exerciseType) {
                "run" -> 9
                "cycle" -> 15
                "hike" -> 10
                else -> 0
            }
            else -> 0
        }
    }

    fun getMinForDate(date: String, exerciseType: String): Int {
        return when (date) {
            getDate(-2) -> when (exerciseType) {
                "run" -> 12
                "cycle" -> 30
                "hike" -> 25
                else -> 0
            }
            getDate(-1) -> when (exerciseType) {
                "run" -> 15
                "cycle" -> 35
                "hike" -> 20
                else -> 0
            }
            getDate(0) -> when (exerciseType) {
                "run" -> 32
                "cycle" -> 40
                "hike" -> 30
                else -> 0
            }
            else -> 0
        }
    }

    fun getTotalKmForDate(date: String): Int {
        val totalKm = getKmForDate(date, "run") + getKmForDate(date, "cycle") + getKmForDate(date, "hike")
        return totalKm
    }

    fun getTotalMinForDate(date: String): Int {
        val totalMin = getMinForDate(date, "run") + getMinForDate(date, "cycle") + getMinForDate(date, "hike")
        return totalMin
    }

    fun getDate(offset: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, offset)
        val format = SimpleDateFormat("dd", Locale.getDefault())
        return format.format(calendar.time)
    }
}
