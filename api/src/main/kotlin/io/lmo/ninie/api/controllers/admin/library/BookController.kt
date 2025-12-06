package io.lmo.ninie.api.controllers.admin.library

import io.lmo.ninie.api.dto.review.request.CreateBookRequest
import io.lmo.ninie.api.dto.review.request.toModel
import io.lmo.ninie.api.dto.review.response.BookResponse
import io.lmo.ninie.api.dto.review.response.toResponse
import io.lmo.ninie.business.library.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/books")
class BookController(val bookService: BookService) {

    @GetMapping
    fun fetch(): Set<BookResponse> = bookService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): BookResponse = bookService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateBookRequest): BookResponse = bookService.create(request.toModel()).toResponse()
}