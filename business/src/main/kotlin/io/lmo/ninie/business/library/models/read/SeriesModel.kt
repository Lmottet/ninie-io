package io.lmo.ninie.business.library.models.read

import io.lmo.ninie.data.entities.library.Series

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
