package io.lmo.ninie.api.dto.library.request

import io.lmo.ninie.business.review.models.create.CreateBookReviewModel

data class CreateBookReviewRequest(
    val content: String,
    val rating: Int,
    val bookId: Long
)

fun CreateBookReviewRequest.toModel() = CreateBookReviewModel(
    content = content,
    rating = rating,
    bookId = bookId
)
