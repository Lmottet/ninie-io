package com.lmo.ninie.io.security

import com.lmo.ninie.io.interfaces.IJwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthenticationFilter(private val jwtTokenProvider: IJwtTokenProvider) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        if (header != null && header.startsWith("Bearer ")) {
            val token = header.removePrefix("Bearer ").trim()
            if (jwtTokenProvider.validateToken(token)) {
                val username = jwtTokenProvider.getUsername(token)
                val roles = jwtTokenProvider.getRoles(token)
                val auth = UsernamePasswordAuthenticationToken(
                    User(username, "", roles),
                    null,
                    roles
                )
                SecurityContextHolder.getContext().authentication = auth
            }
        }

        filterChain.doFilter(request, response)
    }
}
