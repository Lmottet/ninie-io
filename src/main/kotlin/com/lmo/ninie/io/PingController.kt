package com.lmo.ninie.io

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PingController {

    @GetMapping(name ="/")
    fun ping():ResponseEntity<Nothing> =ResponseEntity.accepted().build()
}