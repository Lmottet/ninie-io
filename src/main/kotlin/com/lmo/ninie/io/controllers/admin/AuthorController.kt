package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.request.CreateAuthorRequest
import com.lmo.ninie.io.dto.response.AuthorResponse
import com.lmo.ninie.io.dto.response.toResponse
import com.lmo.ninie.io.services.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorController(val authorService: AuthorService) {

    @GetMapping
    fun fetch(): Set<AuthorResponse> = authorService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long): AuthorResponse = authorService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateAuthorRequest): AuthorResponse = authorService.create(request).toResponse()
}