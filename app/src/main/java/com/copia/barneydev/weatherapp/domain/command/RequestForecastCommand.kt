package com.copia.barneydev.weatherapp.domain.command

import com.copia.barneydev.weatherapp.data.ForecastRequest
import com.copia.barneydev.weatherapp.domain.mapper.ForecastDataMapper
import com.copia.barneydev.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}