package io.lmo.ninie.business.review.models.create

data class CreateAuthorReviewModel(
    val content: String,
    val rating: Int,
    val authorId: Long
)
