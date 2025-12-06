package io.lmo.ninie.business.library.models.read

import io.lmo.ninie.data.entities.library.Book

data class BookModel(
    val id: Long,
    val title: String,
    val tome: Int,
)

fun Book.toModel() = BookModel(
    id = id,
    title = title,
    tome = tome
)