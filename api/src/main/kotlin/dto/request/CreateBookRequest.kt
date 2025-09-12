package com.lmo.ninie.io.dto.request

import com.lmo.ninie.io.models.CreateBookModel

data class CreateBookRequest(
    val title: String,
    val tome: Int,
    val authorId: Long,
    val seriesId: Long?,
)

fun CreateBookRequest.toModel() = CreateBookModel(
    title = title,
    tome = tome,
    authors = listOf(authorId),
    series = listOfNotNull(seriesId)
)