package com.lmo.ninie.io.models

import com.lmo.ninie.io.data.entities.Author

data class AuthorModel(
    val id: Long,
    val firstName: String,
    val lastName: String
)

fun Author.toModel() = AuthorModel(
    id = id,
    firstName = firstName,
    lastName = lastName
)