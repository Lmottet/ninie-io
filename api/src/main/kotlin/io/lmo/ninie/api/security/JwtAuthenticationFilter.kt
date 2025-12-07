package io.lmo.ninie.api.security

import io.lmo.ninie.api.interfaces.IJwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthenticationFilter(
    private val jwtTokenProvider: IJwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val header = request.getHeader("Authorization")

        if (header?.startsWith("Bearer ") == true) {
            val token = header.substring(7)

            if (jwtTokenProvider.validateToken(token)) {
                val username = jwtTokenProvider.getUsername(token)
                val roles = jwtTokenProvider.getRoles(token)

                val auth = UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    roles
                )
                SecurityContextHolder.getContext().authentication = auth
            }
        }

        chain.doFilter(request, response)
    }
}
