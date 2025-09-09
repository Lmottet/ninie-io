package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.response.AuthorResponse
import com.lmo.ninie.io.services.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(val authorService: AuthorService) {

    @GetMapping("/")
    fun fetch(): Set<AuthorResponse> = authorService.list().map { AuthorResponse(it.id, it.firstName, it.lastName) }.toSet()
}