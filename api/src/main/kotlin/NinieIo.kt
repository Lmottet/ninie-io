package com.lmo.ninie.io

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan(basePackages = ["com.lmo"])
@SpringBootApplication(scanBasePackages = ["com.lmo"])
class NinieIo

fun main(args: Array<String>) {
    val port = System.getenv("PORT") ?: "10000"
    System.setProperty("server.port", port)
    System.setProperty("server.address", "0.0.0.0")
    println("Listening on ${System.getProperty("server.address")}:${System.getProperty("server.port")}")

    runApplication<NinieIo>(*args)
}
