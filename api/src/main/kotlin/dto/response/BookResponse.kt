package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.models.BookModel

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