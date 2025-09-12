package com.lmo.ninie.io.models

import com.lmo.ninie.io.data.entities.Series

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
