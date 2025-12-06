package io.lmo.ninie.data.entities.review

import io.lmo.ninie.data.entities.BaseEntity
import io.lmo.ninie.data.entities.library.Book
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class BookReview(
    val content: String,
    val rating: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book
) : BaseEntity()
