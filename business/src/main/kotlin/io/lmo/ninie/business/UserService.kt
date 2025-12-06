package io.lmo.ninie.business

import io.lmo.ninie.data.entities.User
import io.lmo.ninie.data.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(private val userRepository: UserRepository) {

    fun get(id: Long): UserInfoModel = userRepository.findById(id).map { it.toModel() }.orElseThrow()
    fun get(email: String): Optional<UserInfoModel> = userRepository.findByEmail(email).map { it.toModel() }

    fun create(request: CreateUserModel): UserInfoModel =
        userRepository.save(
            User(
                email = request.email,
                password = request.password,
                firstName = request.firstName,
                lastName = request.lastName,
            )
        ).toModel()
}