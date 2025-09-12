package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
