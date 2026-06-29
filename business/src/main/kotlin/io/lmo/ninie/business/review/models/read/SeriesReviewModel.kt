package io.lmo.ninie.business.review.models.read

import io.lmo.ninie.data.entities.review.SeriesReview

data class SeriesReviewModel(
    val id: Long,
    val content: String,
    val rating: Int,
    val seriesId: Long
)

fun SeriesReview.toModel() = SeriesReviewModel(
    id = id,
    content = content,
    rating = rating,
    seriesId = series.id
)