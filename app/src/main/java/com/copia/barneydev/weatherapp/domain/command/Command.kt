package com.copia.barneydev.weatherapp.domain.command

interface Command<out T> {
    fun execute(): T
}