package com.lmo.ninie.io.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class ApiKeyFilter(private val apiKeys: Set<String>) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val apiKey = request.getHeader("X-API-KEY")

        if (apiKey != null && apiKeys.contains(apiKey)) {
            val auth = UsernamePasswordAuthenticationToken(
                "technical-client", // principal (could be more detailed if needed)
                null,
                listOf(SimpleGrantedAuthority("ROLE_TECH"))
            )
            SecurityContextHolder.getContext().authentication = auth
        }

        filterChain.doFilter(request, response)
    }
}
