package io.lmo.ninie.business.review.services

import io.lmo.ninie.business.review.models.create.CreateBookReviewModel
import io.lmo.ninie.business.review.models.read.BookReviewModel
import io.lmo.ninie.business.review.models.read.toModel
import io.lmo.ninie.data.entities.review.BookReview
import io.lmo.ninie.data.repositories.library.BookRepository
import io.lmo.ninie.data.repositories.review.BookReviewRepository
import org.springframework.stereotype.Service

@Service
class BookReviewService(
    private val bookRepository: BookRepository,
    private val bookReviewRepository: BookReviewRepository
) {

    fun list(): List<BookReviewModel> = bookReviewRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): BookReviewModel = bookReviewRepository.findById(id).map { it.toModel() }.orElseThrow()

    fun create(request: CreateBookReviewModel): BookReviewModel =
        bookReviewRepository.save(
            BookReview(
                content = request.content,
                rating = request.rating,
                book = bookRepository.getReferenceById(request.bookId)
            )
        ).toModel()
}