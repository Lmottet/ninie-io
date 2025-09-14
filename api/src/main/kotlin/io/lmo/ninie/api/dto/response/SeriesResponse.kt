package io.lmo.ninie.api.dto.response

import io.lmo.ninie.business.models.SeriesModel

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