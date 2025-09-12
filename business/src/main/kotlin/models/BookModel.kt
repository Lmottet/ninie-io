package com.lmo.ninie.io.models

import com.lmo.ninie.io.data.entities.Book

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