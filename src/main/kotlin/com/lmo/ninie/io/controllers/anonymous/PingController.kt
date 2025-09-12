package com.lmo.ninie.io.controllers

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @GetMapping("/")
    fun home(): ResponseEntity<Nothing> = ResponseEntity.ok().build()

    @GetMapping("/ping")
    fun ping(): ResponseEntity<Nothing> = ResponseEntity.ok().build()
}