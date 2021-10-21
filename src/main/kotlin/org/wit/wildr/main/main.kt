package org.wit.wildr.main

import mu.KotlinLogging
import org.wit.wildr.controllers.wildrController
import org.wit.wildr.models.wildrmodel

private val logger = KotlinLogging.logger {}

val animals = ArrayList<wildrmodel>()


fun main(args: Array<String>) {
    wildrController().start()
}
