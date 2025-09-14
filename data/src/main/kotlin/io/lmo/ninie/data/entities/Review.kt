package io.lmo.ninie.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Review(

    val content: String,
    val rating: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: Author? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    val series: Series? = null
) : BaseEntity()
