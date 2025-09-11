package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Book
import com.lmo.ninie.io.data.entities.Series
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.data.repositories.BookRepository
import com.lmo.ninie.io.data.repositories.SeriesRepository
import com.lmo.ninie.io.dto.request.CreateBookRequest
import com.lmo.ninie.io.dto.request.CreateSeriesRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
    private val seriesRepository: SeriesRepository,
) {

    fun list(): List<Book> = bookRepository.findAll()
    fun get(id: Long): Book = bookRepository.findById(id).orElseThrow()

    @Transactional
    fun create(request: CreateBookRequest): Book {
        val book = Book(title = request.title, tome = request.tome)

        val author = authorRepository.getReferenceById(request.authorId)
        book.addAuthor(author)

        if (request.seriesId != null) {
            val series = seriesRepository.getReferenceById(request.seriesId)
            book.addSeries(series)
        }

        return bookRepository.save(book)
    }
}