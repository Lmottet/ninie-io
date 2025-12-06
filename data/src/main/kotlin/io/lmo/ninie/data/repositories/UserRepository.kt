package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findById(id: String): User
    fun findByEmail(email: String): User?
}
