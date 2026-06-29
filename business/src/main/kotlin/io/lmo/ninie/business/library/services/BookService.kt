package io.lmo.ninie.business.library.services

import io.lmo.ninie.business.library.models.read.BookModel
import io.lmo.ninie.business.library.models.create.CreateBookModel
import io.lmo.ninie.business.library.models.read.toModel
import io.lmo.ninie.data.entities.library.Book
import io.lmo.ninie.data.repositories.library.AuthorRepository
import io.lmo.ninie.data.repositories.library.BookRepository
import io.lmo.ninie.data.repositories.library.SeriesRepository
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