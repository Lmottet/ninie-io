package io.lmo.ninie.api.security

import io.lmo.ninie.data.repositories.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
        if (user.isEmpty) throw UsernameNotFoundException("User not found")

        return User(
            user.get().email,
            user.get().password,
            listOf(SimpleGrantedAuthority("USER"))
        )
    }
}