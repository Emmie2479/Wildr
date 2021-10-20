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
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> listPlacemarks()
            -1 -> println("Irish Wildlife App")
            else -> println("Not an Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Wildr App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("MAIN MENU")
    println(" 1. Irish Species")
    println(" 2. Carnivores")
    println(" 3. Herbivores")
    println("-1. Quit")
    println()
    print("Enter a number : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addPlacemark(){
    println("You Chose the animal")
}

fun updatePlacemark() {
    println("Update the animals statistics")
}

fun listPlacemarks() {
    println("List all the animals")
}