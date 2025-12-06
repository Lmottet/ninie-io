package io.lmo.ninie.api.controllers.anonymous

import io.lmo.ninie.api.dto.LoginRequest
import io.lmo.ninie.api.dto.LoginResponse
import io.lmo.ninie.api.interfaces.IJwtTokenProvider
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
