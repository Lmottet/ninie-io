package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.data.entities.Series

data class SeriesResponse(
    val id: Long,
    val title: String,
    val isFinished: Boolean
)


fun Series.toResponse() = SeriesResponse(
    id = id,
    title = title,
    isFinished = isFinished
)