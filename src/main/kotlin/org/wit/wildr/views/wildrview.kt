package org.wit.placemark.console.views

import org.wit.wildr.main.animals
import org.wit.wildr.models.wildrMemStore
import org.wit.wildr.models.wildrmodel

class wildrview {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Placemark")
        println(" 2. Update Placemark")
        println(" 3. List All Placemarks")
        println(" 4. Search Placemarks")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listAnimals(animals : wildrMemStore) {
        println("List All Placemarks")
        println()
        animals.logAll()
        println()
    }

    fun showAnimal(animal : wildrmodel) {
        if(animal != null)
            println("Placemark Details [ $animal ]")
        else
            println("Placemark Not Found...")
    }

    fun addAnimalData(animal : wildrmodel) : Boolean {

        println()
        print("Enter a Title : ")
        animal.title = readLine()!!
        print("Enter a Description : ")
        animal.description = readLine()!!

        return animal.title.isNotEmpty() && animal.description.isNotEmpty()
    }

    fun updateAnimalData(animal : wildrmodel) : Boolean {

        var tempTitle: String?
        var tempDescription: String?

        if (animal != null) {
            print("Enter a new Title for [ " + animal.title + " ] : ")
            tempTitle = readLine()!!
            print("Enter a new Description for [ " + animal.description + " ] : ")
            tempDescription = readLine()!!

            if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
                animal.title = tempTitle
                animal.description = tempDescription
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}