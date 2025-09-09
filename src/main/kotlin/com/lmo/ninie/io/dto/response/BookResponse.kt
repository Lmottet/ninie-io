package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.data.entities.Book

data class BookResponse(
    val id: Long,
    val title: String,
    val tome: Int
)

fun Book.toResponse() = BookResponse(
    id = id,
    title = title,
    tome = tome
)