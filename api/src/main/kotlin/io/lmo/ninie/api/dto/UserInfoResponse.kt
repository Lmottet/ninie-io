package io.lmo.ninie.api.dto

import io.lmo.ninie.business.UserInfoModel

data class UserInfoResponse(
    val id: Long,
    val firstName: String,
    val lastName: String
)

fun UserInfoModel.toResponse() = UserInfoResponse(
    id = id,
    firstName = firstName,
    lastName = lastName
)