package com.lmo.ninie.io.dto.request

import com.lmo.ninie.io.models.CreateAuthorModel

data class CreateAuthorRequest(
    val firstName: String,
    val lastName: String
)

fun CreateAuthorRequest.toModel() = CreateAuthorModel(
    firstName = firstName,
    lastName = lastName
)
