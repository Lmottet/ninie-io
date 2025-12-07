package io.lmo.ninie.api.controllers.admin

import io.lmo.ninie.api.dto.UserInfoResponse
import io.lmo.ninie.api.dto.review.response.toResponse
import io.lmo.ninie.api.dto.toResponse
import io.lmo.ninie.business.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/users")
class UserController(val userService: UserService) {

    @GetMapping("/me")
    fun me(@PathVariable id: Long): UserInfoResponse = userService.get(id).toResponse()

}