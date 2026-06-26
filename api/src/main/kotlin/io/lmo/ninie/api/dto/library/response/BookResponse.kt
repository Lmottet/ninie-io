package io.lmo.ninie.api.dto.library.response

import io.lmo.ninie.business.library.models.read.BookModel

data class BookResponse(val id: Long, val title: String, val tome: Int)

fun BookModel.toResponse() = BookResponse(id = id, title = title, tome = tome)
