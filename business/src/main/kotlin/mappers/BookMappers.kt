package com.lmo.ninie.io.mappers

import com.lmo.ninie.io.data.entities.Book
import com.lmo.ninie.io.models.BookModel

fun Book.toModel() = BookModel(
    id = id,
    title = title,
    tome = tome
)