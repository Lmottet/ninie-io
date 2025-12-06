package io.lmo.ninie.data.entities

import jakarta.persistence.*

@Entity
@Table(name = "ninie_user")
class User(
    @Column(unique = true, nullable = false, length = 60)
    val email: String,
    @Column(nullable = false, length = 60)
    val password: String,
    @Column(nullable = false, length = 60)
    val lastName: String,
    @Column(nullable = false, length = 60)
    val firstName: String,
) : BaseEntity()
