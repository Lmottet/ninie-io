package io.lmo.ninie.business

import io.lmo.ninie.data.entities.User

data class UserInfoModel(
    val id: Long,
    val firstName: String,
    val lastName: String
)

fun User.toModel() = UserInfoModel(
    id = id,
    firstName = firstName,
    lastName = lastName
)