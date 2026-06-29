package io.lmo.ninie.business.library.models.read

import io.lmo.ninie.data.entities.library.Author

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