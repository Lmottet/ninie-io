package com.lmo.ninie.io

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class NinieIo

fun main(args: Array<String>) {

    runApplication<NinieIo>(*args)
}
