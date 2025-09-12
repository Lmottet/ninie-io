package com.lmo.ninie.io.interfaces

import org.springframework.security.core.authority.SimpleGrantedAuthority

interface IJwtTokenProvider {
    fun generateToken(email: String): String
    fun validateToken(token: String): Boolean
    fun getUsername(token: String): String
    fun getRoles(token: String): List<SimpleGrantedAuthority>
}