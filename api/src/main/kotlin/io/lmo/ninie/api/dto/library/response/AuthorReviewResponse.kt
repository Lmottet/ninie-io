package io.lmo.ninie.api.dto.library.response

import io.lmo.ninie.business.review.models.read.AuthorReviewModel

data class AuthorReviewResponse(
    val id: Long,
    val content: String,
    val rating: Int,
    val authorId: Long
)

fun AuthorReviewModel.toResponse() = AuthorReviewResponse(
    id = id,
    content = content,
    rating = rating,
    authorId = authorId
)