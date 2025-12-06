package io.lmo.ninie.api.dto.review.request

import io.lmo.ninie.business.library.models.create.CreateAuthorModel

data class CreateAuthorRequest(
    val firstName: String,
    val lastName: String
)

fun CreateAuthorRequest.toModel() = CreateAuthorModel(
    firstName = firstName,
    lastName = lastName
)
