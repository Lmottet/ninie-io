package com.lmo.ninie.io.dto.response

import com.lmo.ninie.io.models.AuthorModel

data class AuthorResponse(
    val id: Long,
    val firstName: String,
    val lastName: String
)

fun AuthorModel.toResponse() = AuthorResponse(
    id = id,
    firstName = firstName,
    lastName = lastName
)