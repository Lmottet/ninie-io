package io.lmo.ninie.data.entities

import jakarta.persistence.*

@Entity
@Table(name = "ninie_user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    val lastName: String,
    val firstName: String,
)
