package io.lmo.ninie.business.models

import io.lmo.ninie.data.entities.Series

data class SeriesModel(
    val id: Long,
    val title: String,
    val isFinished: Boolean
)

fun Series.toModel() = SeriesModel(
    id = id,
    title = title,
    isFinished = isFinished
)
