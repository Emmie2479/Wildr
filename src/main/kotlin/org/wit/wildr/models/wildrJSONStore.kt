package org.wit.wildr.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.wildr.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "animals.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<wildrmodel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class wildrJSONStore : wildrstore {

    var animals = mutableListOf<wildrmodel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<wildrmodel> {
        return animals
    }

    override fun findOne(id: Long) : wildrmodel? {
        var foundAnimal: wildrmodel? = animals.find { p -> p.id == id }
        return foundAnimal
    }

    override fun create(animal: wildrmodel) {
        animal.id = generateRandomId()
        animals.add(animal)
        serialize()
    }

    override fun update(animal: wildrmodel) {
        var foundAnimal = findOne(animal.id!!)
        if (foundAnimal != null) {
            foundAnimal.title = animal.title
            foundAnimal.description = animal.description
        }
        serialize()
    }

    override fun delete(animal: wildrmodel) {
        animals.remove(animal)
        serialize()
    }

    internal fun logAll() {
        animals.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(animals, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        animals = Gson().fromJson(jsonString, listType)
    }
}