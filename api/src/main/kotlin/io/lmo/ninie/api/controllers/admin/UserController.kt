package io.lmo.ninie.api.controllers.admin

import io.lmo.ninie.api.dto.UserInfoResponse
import io.lmo.ninie.api.dto.toResponse
import io.lmo.ninie.business.UserService
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserController(private val userService: UserService) {

    @GetMapping("/me")
    fun me(authentication: Authentication): UserInfoResponse =
        userService.get(authentication.name)?.toResponse()
            ?: throw org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND)
}
