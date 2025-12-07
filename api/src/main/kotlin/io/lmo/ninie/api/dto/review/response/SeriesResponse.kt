package io.lmo.ninie.api.dto.review.response

import io.lmo.ninie.business.library.models.read.SeriesModel

data class SeriesResponse(
    val id: Long,
    val title: String,
    val isFinished: Boolean
)

fun SeriesModel.toResponse() = SeriesResponse(
    id = id,
    title = title,
    isFinished = isFinished
)