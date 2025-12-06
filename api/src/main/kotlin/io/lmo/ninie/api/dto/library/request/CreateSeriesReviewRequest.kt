package io.lmo.ninie.api.dto.library.request

import io.lmo.ninie.business.review.models.create.CreateSeriesReviewModel

data class CreateSeriesReviewRequest(
    val content: String,
    val rating: Int,
    val seriesId: Long
)

fun CreateSeriesReviewRequest.toModel() = CreateSeriesReviewModel(
    content = content,
    rating = rating,
    seriesId = seriesId
)
