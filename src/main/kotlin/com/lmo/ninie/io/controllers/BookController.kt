package com.lmo.ninie.io.controllers

import com.lmo.ninie.io.dto.response.BookResponse
import com.lmo.ninie.io.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val bookService: BookService) {

    @GetMapping("/")
    fun fetch(): Set<BookResponse> = bookService.list().map { BookResponse(it.id, it.title, it.tome) }.toSet()
}