package org.wit.wildr.main

import mu.KotlinLogging
import org.wit.wildr.models.wildrmodel

private val logger = KotlinLogging.logger {}

var animal = wildrmodel()
val animals = ArrayList<wildrmodel>()

fun main(args: Array<String>) {
    logger.info { "Initializing Wildr App" }
    println("Wildr Kotlin App Version 2.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addAnimal()
            2 -> updateAnimal()
            3 -> listAnimals()
            -1 -> println("Leaving Wildr")
            else -> println("Incorrect Option")
        }
        println()
    } while (input != -1)
    logger.info { "Closing Wildr App" }
}

fun menu() : Int {

    var option : Int
    var input: String?

    println("Home Page")
    println(" 1. Add Animals")
    println(" 2. Update the Animals")
    println(" 3. List all the available animals")
    println("-1. Quit")
    println()
    print("Enter you selection : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addAnimal(){
    println("Add Animal")
    println()
    print("Enter the name of an Animal : ")
    animal.title = readLine()!!
    print("Describe the Animal : ")
    animal.description = readLine()!!

    if (animal.title.isNotEmpty() && animal.description.isNotEmpty()) {
        animals.add(animal.copy())
        logger.info("Animal has been successfully added : [ $animal ]")
    }
    else
        logger.info("The animal has not been added")
}

fun updateAnimal() {
    println("Update Animal")
    println()
    print("Enter a new name for [ " + animal.title + " ] : ")
    animal.title = readLine()!!
    print("Enter a new Description for the [ " + animal.description + " ] : ")
    animal.description = readLine()!!
    println("You have successfully updated [ " + animal.title + " ] as the new animal " +
            "and [ " + animal.description + " ] for the animals description")
}

fun listAnimals() {
    println("List All the Animals")
    println()
    animals.forEach { logger.info("${it}") }
}