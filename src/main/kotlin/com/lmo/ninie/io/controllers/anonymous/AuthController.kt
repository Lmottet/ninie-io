package com.lmo.ninie.io.controllers.anonymous

import com.lmo.ninie.io.dto.request.LoginRequest
import com.lmo.ninie.io.dto.response.LoginResponse
import com.lmo.ninie.io.security.JwtTokenProvider
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider
) {

    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): ResponseEntity<LoginResponse> {
        val authToken = UsernamePasswordAuthenticationToken(req.email, req.password)
        val auth = authenticationManager.authenticate(authToken)

        val jwt = jwtTokenProvider.generateToken(req.email)
        return ResponseEntity.ok(LoginResponse(jwt))
    }
}
