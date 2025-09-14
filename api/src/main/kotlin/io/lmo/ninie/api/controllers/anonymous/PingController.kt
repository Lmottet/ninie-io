package io.lmo.ninie.api.controllers.anonymous

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @GetMapping("/")
    fun home(): ResponseEntity<Nothing> = ResponseEntity.ok().build()

    @GetMapping("/ping")
    fun ping(): ResponseEntity<Nothing> = ResponseEntity.ok().build()
}