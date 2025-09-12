package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.models.SeriesModel

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