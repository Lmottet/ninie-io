package io.lmo.ninie.api.controllers.anonymous

import io.lmo.ninie.api.dto.LoginRequest
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val securityContextRepository: HttpSessionSecurityContextRepository
) {
    @PostMapping("/login")
    fun login(
        @RequestBody req: LoginRequest,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): ResponseEntity<Unit> =
        try {
            val auth = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(req.email, req.password)
            )
            val context = SecurityContextHolder.createEmptyContext().also { it.authentication = auth }
            SecurityContextHolder.setContext(context)
            securityContextRepository.saveContext(context, request, response)
            ResponseEntity.ok().build()
        } catch (e: BadCredentialsException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

    @PostMapping("/logout")
    fun logout(request: HttpServletRequest): ResponseEntity<Unit> {
        request.getSession(false)?.invalidate()
        SecurityContextHolder.clearContext()
        return ResponseEntity.ok().build()
    }
}
