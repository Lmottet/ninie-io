package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.request.CreateBookRequest
import com.lmo.ninie.io.dto.response.BookResponse
import com.lmo.ninie.io.dto.response.toResponse
import com.lmo.ninie.io.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(val bookService: BookService) {

    @GetMapping
    fun fetch(): Set<BookResponse> = bookService.list().map { it.toResponse() }.toSet()

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): BookResponse = bookService.get(id).toResponse()

    @PostMapping
    fun create(@RequestBody request: CreateBookRequest): BookResponse = bookService.create(request).toResponse()
}