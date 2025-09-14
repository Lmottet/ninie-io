package io.lmo.ninie.api.interfaces

import org.springframework.security.core.authority.SimpleGrantedAuthority

interface IJwtTokenProvider {
    fun generateToken(email: String): String
    fun validateToken(token: String): Boolean
    fun getUsername(token: String): String
    fun getRoles(token: String): List<SimpleGrantedAuthority>
}