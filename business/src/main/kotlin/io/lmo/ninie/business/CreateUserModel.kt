package io.lmo.ninie.business

data class CreateUserModel(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,

)
