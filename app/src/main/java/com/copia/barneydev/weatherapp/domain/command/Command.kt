package com.copia.barneydev.weatherapp.domain.command

/**
 * We use Commands to execute an operation and return an object of class specified by generic type.
 * if we want our Command to return nothing, we can specify Unit as its type.
 */

interface Command<out T> {
    fun execute(): T
}