package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Book
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.data.repositories.BookRepository
import com.lmo.ninie.io.data.repositories.SeriesRepository
import com.lmo.ninie.io.models.BookModel
import com.lmo.ninie.io.models.CreateBookModel
import com.lmo.ninie.io.models.toModel
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
    private val seriesRepository: SeriesRepository,
) {

    fun list(): List<BookModel> = bookRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): BookModel = bookRepository.findById(id).map { it.toModel() }.orElseThrow()

    @Transactional
    fun create(request: CreateBookModel): BookModel {
        val book = Book(title = request.title, tome = request.tome)

        request.authors.forEach { book.addAuthor(authorRepository.getReferenceById(it)) }
        request.series.forEach { book.addSeries(seriesRepository.getReferenceById(it)) }

        return bookRepository.save(book).toModel()
    }
}