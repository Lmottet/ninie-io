package com.lmo.ninie.io

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class NinieIo

fun main(args: Array<String>) {
    val port = System.getenv("PORT") ?: "8080"
    System.setProperty("server.port", port)
    System.setProperty("server.address", "0.0.0.0")
    runApplication<NinieIo>(*args)
}
