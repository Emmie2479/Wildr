package org.wit.wildr

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    logger.info { "Launching Wildr App" }
    println("Wildr Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> println("You pick the species type your looking for")
            -1 -> println("Leaving Wildr")
            else -> println("Not an Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Wildr App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Home")
    println("Carnivores")
    println("Herbivores")
    println("Other species")
    println("Return")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}