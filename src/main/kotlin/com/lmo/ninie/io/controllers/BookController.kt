package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.response.BookResponse
import com.lmo.ninie.io.dto.response.toResponse
import com.lmo.ninie.io.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/books")
class BookController(val bookService: BookService) {

    @GetMapping("/")
    fun fetch(): Set<BookResponse> = bookService.list().map { it.toResponse() }.toSet()
}