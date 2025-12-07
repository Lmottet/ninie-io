package io.lmo.ninie.api.dto.review.request

import io.lmo.ninie.business.library.models.create.CreateSeriesModel

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
