package org.wit.wildr.controllers

import mu.KotlinLogging
import org.wit.wildr.models.wildrJSONStore
import org.wit.wildr.models.wildrmodel
import org.wit.wildr.views.wildrview

class wildrController {

    val animals = wildrJSONStore()
    val wildrView = wildrview()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing the Wildr App" }
        println("Wildr Kotlin App Version 4.0")
    }
    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                -99 -> defaultData()
                -1 -> println("Leaving App")
                else -> println("Not an Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }
    fun menu() :Int { return wildrView.menu() }

    fun add(){
        var anAnimal = wildrmodel()

        if (wildrView.addAnimalData(anAnimal))
            animals.create(anAnimal)
        else
            logger.info("Animal Not Added")
    }

    fun list() {
        wildrView.listAnimals(animals)
    }

    fun update() {

        wildrView.listAnimals(animals)
        var searchId = wildrView.getId()
        val anAnimal = search(searchId)

        if(anAnimal != null) {
            if(wildrView.updateAnimalData(anAnimal)) {
                animals.update(anAnimal)
                wildrView.showAnimal(anAnimal)
                logger.info("Animal Updated : [ $anAnimal ]")
            }
            else
                logger.info("Animal Not Updated")
        }
        else
            println("Animal Not Updated...")
    }

    fun delete() {
        wildrView.listAnimals(animals)
        var searchId = wildrView.getId()
        val anAnimal = search(searchId)

        if(anAnimal != null) {
            animals.delete(anAnimal)
            println("Animal Deleted...")
            wildrView.listAnimals(animals)
        }
        else
            println("Animal Not Deleted...")
    }

    fun search() {
        val anAnimal = search(wildrView.getId())!!
        wildrView.showAnimal(anAnimal)
    }


    fun search(id: Long) : wildrmodel? {
        var foundAnimal = animals.findOne(id)
        return foundAnimal
    }

    fun defaultData() {
        animals.create(wildrmodel(1, "European Grey wolf", "Largest of the European wolves"))
        animals.create(wildrmodel(2, "Red Deer", "The most common species of deer"))
        animals.create(wildrmodel(3, "Barn owl", "The most recognised owl"))
    }
}