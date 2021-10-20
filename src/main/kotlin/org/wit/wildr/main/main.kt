package org.wit.wildr.main

import mu.KotlinLogging
import org.wit.wildr.models.wildrmodel

private val logger = KotlinLogging.logger {}

var title = ""
var description = ""

var wildr = wildrmodel()

fun main(args: Array<String>) {
    logger.info { "Initialising Wildr App" }
    println("Wildr Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> listPlacemarks()
            -1 -> println("Leaving Wildr")
            else -> println("Not a valid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Exiting Wildr App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Home page")
    println(" 1. Add Animal")
    println(" 2. Update Animals")
    println(" 3. List All the Animals")
    println("-1. Leave")
    println()
    print("Enter your number choice: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addPlacemark(){

    println("Add an Animal")
    println()
    print("Enter your Animal : ")
    title = readLine()!!
    print("Give a Description of the Animal: ")
    description = readLine()!!
    println("You've entered [ $title ] for the animal and [ $description ] for the animals description")
}

fun updatePlacemark() {
    println("Update Animal")
    println()
    print("Enter a new Animal for [ $title ] : ")
    title = readLine()!!
    print("Enter the new Description for [ $description ] : ")
    description = readLine()!!
    println("You have successfully updated [ $title ] for the animal and [ $description ] for the animals description")
}

fun listPlacemarks() {
    println("All Animals listed")
}