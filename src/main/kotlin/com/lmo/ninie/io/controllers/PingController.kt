package com.lmo.ninie.io.controllers

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PingController {

    @GetMapping(name = "/ping")
    fun ping(): ResponseEntity<Nothing> = ResponseEntity.accepted().build()
}