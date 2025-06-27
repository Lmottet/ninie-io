package com.lmo.ninie.io

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class NinieIo

fun main(args: Array<String>) {
    println("Listening on ${System.getProperty("server.address")}:${System.getProperty("server.port")}")

    runApplication<NinieIo>(*args)
}
