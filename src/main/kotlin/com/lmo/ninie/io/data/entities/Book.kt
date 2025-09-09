package com.lmo.ninie.io.data.entities

import jakarta.persistence.*

@Entity
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val tome: Int,

    @OneToMany(mappedBy = "book")
    val authorBooks: MutableSet<AuthorBook> = mutableSetOf()
)
