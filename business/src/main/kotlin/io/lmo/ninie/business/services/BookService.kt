package io.lmo.ninie.business.services

import io.lmo.ninie.business.models.BookModel
import io.lmo.ninie.business.models.CreateBookModel
import io.lmo.ninie.business.models.toModel
import io.lmo.ninie.data.entities.Book
import io.lmo.ninie.data.repositories.AuthorRepository
import io.lmo.ninie.data.repositories.BookRepository
import io.lmo.ninie.data.repositories.SeriesRepository
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