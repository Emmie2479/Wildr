package org.wit.wildr.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class wildrMemStore : wildrstore {

    val animals = ArrayList<wildrmodel>()

    override fun findAll(): List<wildrmodel> {
        return animals
    }

    override fun findOne(id: Long) : wildrmodel? {
        var foundAnimal: wildrmodel? = animals.find { p -> p.id == id }
        return foundAnimal
    }

    override fun create(animal: wildrmodel) {
        animal.id = getId()
        animals.add(animal)
        logAll()
    }

    override fun update(animal: wildrmodel) {
        var foundAnimal = findOne(animal.id!!)
        if (foundAnimal != null) {
            foundAnimal.title = animal.title
            foundAnimal.description = animal.description
        }
    }

    internal fun logAll() {
        animals.forEach { logger.info("${it}") }
    }
}