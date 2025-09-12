package com.lmo.ninie.io.mappers

import com.lmo.ninie.io.data.entities.Series
import com.lmo.ninie.io.models.SeriesModel

fun Series.toModel() = SeriesModel(
    id = id,
    title = title,
    isFinished = isFinished
)