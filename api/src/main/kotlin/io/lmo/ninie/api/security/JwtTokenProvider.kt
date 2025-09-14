package io.lmo.ninie.api.security

import io.lmo.ninie.api.interfaces.IJwtTokenProvider
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.*
import javax.crypto.SecretKey

class JwtTokenProvider(secretBase64: String) : IJwtTokenProvider {

    private val decodedKey = Base64.getDecoder().decode(secretBase64)
    private val key: SecretKey = Keys.hmacShaKeyFor(decodedKey)
    private val validityInMs: Long = 15 * 60 * 1000 // 15 minutes

    override fun generateToken(email: String): String {
        val now = Date()
        val expiry = Date(now.time + validityInMs)
        val roles = listOf(SimpleGrantedAuthority("USER"))

        return Jwts.builder()
            .subject(email)
            .claim("roles", roles)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(key)
            .compact()
    }

    override fun validateToken(token: String): Boolean =
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
            true
        } catch (ex: Exception) {
            false
        }

    override fun getUsername(token: String): String = getClaims(token).subject

    override fun getRoles(token: String): List<SimpleGrantedAuthority> =
        (getClaims(token)["roles"] as List<*>)
            .filterIsInstance<String>()
            .map { SimpleGrantedAuthority(it) }

    private fun getClaims(token: String): Claims =
        Jwts.parser().verifyWith(key).build().parseSignedClaims(token).payload
}
