package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Book
import com.lmo.ninie.io.data.repositories.BookRepository
import com.lmo.ninie.io.dto.request.CreateBookRequest
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun list(): List<Book> = bookRepository.findAll()

    fun create(request: CreateBookRequest): Book = bookRepository.save(Book(title = request.title, tome = request.tome))
}