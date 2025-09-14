package io.lmo.ninie.business.models

import io.lmo.ninie.data.entities.Author

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