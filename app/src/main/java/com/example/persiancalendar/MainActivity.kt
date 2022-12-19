package com.example.persiancalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.persiancalendar.data.CalendarData
import com.example.persiancalendar.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        private const val BASE_URL = "https://api.keybit.ir/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(CalendarApi::class.java)
        retrofitService.getDateAndTime().enqueue(object : Callback<CalendarData?> {
            override fun onResponse(call: Call<CalendarData?>, response: Response<CalendarData?>) {
                val responseBody = response.body()!!
                binding.dateTextView.text = responseBody.date.full.official.iso.fa
            }

            override fun onFailure(call: Call<CalendarData?>, t: Throwable) {
                binding.dateTextView.text = t.message.toString()
            }
        })
    }
}