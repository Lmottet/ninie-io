package com.lmo.ninie.io.controllers.anonymous

import com.lmo.ninie.io.dto.request.LoginRequest
import com.lmo.ninie.io.dto.response.LoginResponse
import com.lmo.ninie.io.interfaces.IJwtTokenProvider
import org.springframework.http.HttpStatusCode
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
    private val jwtTokenProvider: IJwtTokenProvider
) {
    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): ResponseEntity<LoginResponse> {
        val authRequest = UsernamePasswordAuthenticationToken(req.email, req.password)
        try {
            val auth = authenticationManager.authenticate(authRequest)
            if (auth.isAuthenticated) return ResponseEntity.ok(LoginResponse(jwtTokenProvider.generateToken(req.email)))
        } catch (e: Exception) {

        }
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).build()
    }
}
