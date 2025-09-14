package io.lmo.ninie.api.dto.response

import io.lmo.ninie.business.models.BookModel

data class BookResponse(
    val id: Long,
    val title: String,
    val tome: Int
)

fun BookModel.toResponse() = BookResponse(
    id = id,
    title = title,
    tome = tome
)