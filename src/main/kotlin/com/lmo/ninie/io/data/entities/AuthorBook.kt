package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class AuthorBook(
    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book,
): BaseEntity()
