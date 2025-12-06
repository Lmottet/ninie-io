package io.lmo.ninie.business

import io.lmo.ninie.data.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun get(id: Long): UserInfoModel = userRepository.findById(id).map { it.toModel() }.orElseThrow()

}