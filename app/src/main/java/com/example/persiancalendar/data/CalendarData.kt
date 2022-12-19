package com.example.persiancalendar.data

data class CalendarData(
    val date: Date,
    val season: Season,
    val time12: Time12,
    val time24: Time24,
    val timestamp: Timestamp,
    val timezone: Timezone,
    val unix: Unix
)