package io.lmo.ninie.api.dto.request

import io.lmo.ninie.business.models.CreateAuthorModel

data class CreateAuthorRequest(
    val firstName: String,
    val lastName: String
)

fun CreateAuthorRequest.toModel() = CreateAuthorModel(
    firstName = firstName,
    lastName = lastName
)
