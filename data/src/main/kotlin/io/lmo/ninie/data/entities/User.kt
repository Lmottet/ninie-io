package io.lmo.ninie.data.entities

import jakarta.persistence.*

@Entity
@Table(name = "ninie_user") // avoid h2 clash because user is a reserved keyword. review when implementing supabase for actual db
class User(
    @Column(unique = true, nullable = false)
    val email: String,
    @Column(nullable = false)
    val password: String,

    val lastName: String,
    val firstName: String,
)  : BaseEntity()
