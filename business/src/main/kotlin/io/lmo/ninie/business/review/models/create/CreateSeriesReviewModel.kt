package io.lmo.ninie.business.review.models.create

data class CreateSeriesReviewModel (
    val content: String,
    val rating: Int,
    val seriesId: Long
)
