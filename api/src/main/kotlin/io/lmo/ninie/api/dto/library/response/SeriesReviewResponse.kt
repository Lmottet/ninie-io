package io.lmo.ninie.api.dto.library.response

import io.lmo.ninie.business.review.models.read.SeriesReviewModel

data class SeriesReviewResponse(
    val id: Long,
    val content: String,
    val rating: Int,
    val seriesId: Long
)

fun SeriesReviewModel.toResponse() = SeriesReviewResponse(
    id = id,
    content = content,
    rating = rating,
    seriesId = seriesId
)