package io.lmo.ninie.business.review.models.create

data class CreateBookReviewModel (
    val content: String,
    val rating: Int,
    val bookId: Long
)
