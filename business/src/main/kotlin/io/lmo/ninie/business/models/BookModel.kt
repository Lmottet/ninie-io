package io.lmo.ninie.business.models

import io.lmo.ninie.data.entities.Book


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