package com.copia.barneydev.weatherapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.copia.barneydev.weatherapp.R
import com.copia.barneydev.weatherapp.ui.adapter.ForecastListAdapter
import com.copia.barneydev.weatherapp.domain.command.RequestForecastCommand
import com.copia.barneydev.weatherapp.domain.model.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

// This activity will render a list of daily forecasts for a given range of days
class MainActivity : AppCompatActivity() {

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // message.text = "Hello Jomo" USING ANKO, MESSAGE WAS A TEXT FIELD
        // OLD WAY val forcastList = findViewById(R.id.forecast_list) as RecyclerView

        // val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        // We use android extensions to remove FindBYID HERE
        forecastList.layoutManager = LinearLayoutManager(this)
       // forecastList.adapter = ForecastListAdapter(items)

        doAsync {
           val result = RequestForecastCommand("94043").execute()
           uiThread {
               val adapter = ForecastListAdapter(result) { forecast -> toast(forecast.date) } // Lambda
               forecastList.adapter = adapter
           }
        }
    }
}
