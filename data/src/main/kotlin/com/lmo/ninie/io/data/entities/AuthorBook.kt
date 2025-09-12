package com.lmo.ninie.io.data.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.Instant

@Entity
@EntityListeners(AuditingEntityListener::class)
class AuthorBook(
    @EmbeddedId
    val id: AuthorBookId = AuthorBookId(),

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    val book: Book,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdOn: Instant? = null
)

@Embeddable
data class AuthorBookId(
    val authorId: Long = 0,
    val bookId: Long = 0
) : Serializable
