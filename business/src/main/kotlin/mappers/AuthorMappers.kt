package com.lmo.ninie.io.mappers

import com.lmo.ninie.io.data.entities.Author
import com.lmo.ninie.io.models.AuthorModel

fun Author.toModel() = AuthorModel(
    id = id,
    firstName = firstName,
    lastName = lastName
)