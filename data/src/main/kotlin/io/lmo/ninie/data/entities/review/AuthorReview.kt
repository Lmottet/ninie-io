package io.lmo.ninie.data.entities.review

import io.lmo.ninie.data.entities.BaseEntity
import io.lmo.ninie.data.entities.library.Author
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class AuthorReview(
    @Column(nullable = false, length = 5000)
    val content: String,
    @Column(nullable = false)
    val rating: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: Author
) : BaseEntity()
