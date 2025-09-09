package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.data.entities.Author

data class AuthorResponse(
    val id: Long,
    val firstName: String,
    val lastName: String
)

fun Author.toResponse() = AuthorResponse(
    id = id,
    firstName = firstName,
    lastName = lastName
)