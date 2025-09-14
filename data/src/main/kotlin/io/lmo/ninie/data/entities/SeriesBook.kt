package io.lmo.ninie.data.entities

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.Instant

@Entity
@EntityListeners(AuditingEntityListener::class)
class SeriesBook(
    @EmbeddedId
    val id: SeriesBookId = SeriesBookId(),

    @ManyToOne
    @MapsId("seriesId")
    @JoinColumn(name = "series_id")
    val series: Series,

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    val book: Book,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdOn: Instant? = null
)


@Embeddable
data class SeriesBookId(
    val seriesId: Long = 0,
    val bookId: Long = 0
) : Serializable