package io.lmo.ninie.api.dto.library.response

import io.lmo.ninie.business.review.models.read.BookReviewModel

data class BookReviewResponse(
    val id: Long,
    val content: String,
    val rating: Int,
    val bookId: Long
)

fun BookReviewModel.toResponse() = BookReviewResponse(
    id = id,
    content = content,
    rating = rating,
    bookId = bookId
)