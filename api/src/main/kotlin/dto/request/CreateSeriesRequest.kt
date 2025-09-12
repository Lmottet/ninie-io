package com.lmo.ninie.io.dto.request

import com.lmo.ninie.io.models.CreateSeriesModel

data class CreateSeriesRequest(
    val title: String,
    val isFinished: Boolean,
    val authorId: Long
    )

fun CreateSeriesRequest.toModel() = CreateSeriesModel(
    title = title,
    isFinished = isFinished,
    authors = listOf(authorId),
)
