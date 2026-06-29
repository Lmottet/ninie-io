package io.lmo.ninie.business.review.models.read

import io.lmo.ninie.data.entities.review.BookReview

data class BookReviewModel(
    val id: Long,
    val content: String,
    val rating: Int,
    val bookId: Long
)

fun BookReview.toModel() = BookReviewModel(
    id = id,
    content = content,
    rating = rating,
    bookId = book.id
)