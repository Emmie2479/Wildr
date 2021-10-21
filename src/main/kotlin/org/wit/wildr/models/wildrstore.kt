package org.wit.wildr.models

interface wildrstore {
    fun findAll(): List<wildrmodel>
    fun findOne(id: Long): wildrmodel?
    fun create(animal: wildrmodel)
    fun update(animal: wildrmodel)
    fun delete(animal: wildrmodel)
}