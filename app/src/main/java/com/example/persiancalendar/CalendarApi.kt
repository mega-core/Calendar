package com.example.persiancalendar

import com.example.persiancalendar.data.CalendarData
import retrofit2.Call
import retrofit2.http.GET

interface CalendarApi {

    @GET("time")
    fun getDateAndTime(): Call<CalendarData>
}