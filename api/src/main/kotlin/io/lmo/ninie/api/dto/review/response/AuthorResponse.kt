package io.lmo.ninie.api.dto.review.response

import io.lmo.ninie.business.library.models.read.AuthorModel

data class AuthorResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val fullName: String
)

fun AuthorModel.toResponse() = AuthorResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    fullName = "$firstName $lastName"
)