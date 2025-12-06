package io.lmo.ninie.api.dto.library.request

import io.lmo.ninie.business.review.models.create.CreateAuthorReviewModel

data class CreateAuthorReviewRequest(
    val content: String,
    val rating: Int,
    val authorId: Long
)

fun CreateAuthorReviewRequest.toModel() = CreateAuthorReviewModel(
    content = content,
    rating = rating,
    authorId = authorId
)
