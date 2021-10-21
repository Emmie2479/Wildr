package org.wit.wildr.views

import org.wit.wildr.main.animals
import org.wit.wildr.models.wildrJSONStore
import org.wit.wildr.models.wildrMemStore
import org.wit.wildr.models.wildrmodel

class wildrview {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("HOME")
        println(" 1. Add Animal")
        println(" 2. Update Animal")
        println(" 3. List All Animals")
        println(" 4. Search Animals")
        println("-1. Quit")
        println()
        print("Enter Choice : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listAnimals(animals : wildrJSONStore) {
        println("List All Animals")
        println()
        animals.logAll()
        println()
    }

    fun showAnimal(animal : wildrmodel) {
        if(animal != null)
            println("Animal Details [ $animal ]")
        else
            println("Animal Not Found...")
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