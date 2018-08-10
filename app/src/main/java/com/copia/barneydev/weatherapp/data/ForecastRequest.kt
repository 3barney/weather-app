package com.copia.barneydev.weatherapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

class Request(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}

// If we need some static properties, constants or functions in a class, we can
// use a companion object. This object will be shared among all instances
// of the class, the same as a static field or method would do in Java.