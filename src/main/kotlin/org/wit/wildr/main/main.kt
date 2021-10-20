package org.wit.wildr.main

import mu.KotlinLogging
import org.wit.wildr.models.wildrmodel

private val logger = KotlinLogging.logger {}

val animals = ArrayList<wildrmodel>()

fun main(args: Array<String>) {
    logger.info { "Initializing the Wildr App" }
    println("Wildr Kotlin App Version 3.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addAnimal()
            2 -> updateAnimal()
            3 -> listAnimals()
            4 -> searchAnimal()
            -99 -> defaultData()
            -1 -> println("Closing Wildr")
            else -> println("Incorrect Option")
        }
        println()
    } while (input != -1)
    logger.info { "Exiting Wildr" }
}

fun menu() : Int {

    var option : Int
    var input: String?

    println("Home")
    println(" 1. Add an Animal")
    println(" 2. Update an Animals details")
    println(" 3. List all the Animals")
    println(" 4. Search the Animals")
    println("-1. Quit")
    println()
    print("Enter your choice: ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addAnimal(){
    var aAnimal = wildrmodel()
    println("Add an Animal ")
    println()
    print("Enter the Animals name : ")
    aAnimal.title = readLine()!!
    print("Enter a Description for the animal : ")
    aAnimal.description = readLine()!!

    if (aAnimal.title.isNotEmpty() && aAnimal.description.isNotEmpty()) {
        aAnimal.id = animals.size.toLong()
        animals.add(aAnimal.copy())
        logger.info("Animal successfully added : [ $aAnimal ]")
    }
    else
        logger.info("Animal was Not Added")
}

fun updateAnimal() {
    println("Update an Animal")
    println()
    listAnimals()
    var searchId = getId()
    val aAnimal = search(searchId)

    if(aAnimal != null) {
        print("Enter the new name for [ " + aAnimal.title + " ] : ")
        aAnimal.title = readLine()!!
        print("Type th enew description for [ " + aAnimal.description + " ] : ")
        aAnimal.description = readLine()!!
        println(
            "You have successfully updated [ " + aAnimal.title + " ] for the animals name " +
                    "and [ " + aAnimal.description + " ] for the animals description"
        )
    }
    else
        println("Animal failed to update")
}

fun listAnimals() {
    println("List All the Animals")
    println()
    animals.forEach { logger.info("${it}") }
    println()
}

fun searchAnimal() {

    var searchId = getId()
    val aAnimal = search(searchId)

    if(aAnimal != null)
        println("The Animals Details [ $aAnimal ]")
    else
        println("Animal not found")
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter an animals id to Search: ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : wildrmodel? {
    var foundAnimal: wildrmodel? = animals.find { p -> p.id == id }
    return foundAnimal
}

fun defaultData() {
    animals.add(wildrmodel(1, "European Grey wolf", "Largest of the European wolves"))
    animals.add(wildrmodel(2, "Red Deer", "The most common species of deer"))
    animals.add(wildrmodel(3, "Barn owl", "The most recognised owl"))
}
