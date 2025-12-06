package io.lmo.ninie.business.review.models.read

import io.lmo.ninie.data.entities.review.AuthorReview

data class AuthorReviewModel(
    val id: Long,
    val content: String,
    val rating: Int,
    val authorId: Long
)

fun AuthorReview.toModel() = AuthorReviewModel(
    id = id,
    content = content,
    rating = rating,
    authorId = author.id
)