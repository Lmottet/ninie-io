package io.lmo.ninie.api.controllers.admin.library

import io.lmo.ninie.api.dto.review.request.CreateAuthorRequest
import io.lmo.ninie.api.dto.review.request.toModel
import io.lmo.ninie.api.dto.review.response.AuthorResponse
import io.lmo.ninie.api.dto.review.response.toResponse
import io.lmo.ninie.business.library.services.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/authors")
class AuthorController(val authorService: AuthorService) {

    @GetMapping
    fun fetch(): Set<AuthorResponse> = authorService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AuthorResponse = authorService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateAuthorRequest): AuthorResponse = authorService.create(request.toModel()).toResponse()
}