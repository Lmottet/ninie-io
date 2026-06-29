package io.lmo.ninie.data.entities.library

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.Instant

@Entity
@EntityListeners(AuditingEntityListener::class)
class AuthorSeries(
    @EmbeddedId
    val id: AuthorSeriesId = AuthorSeriesId(),

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @MapsId("seriesId")
    @JoinColumn(name = "series_id")
    val series: Series,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdOn: Instant? = null
)

@Embeddable
data class AuthorSeriesId(
    val authorId: Long = 0,
    val seriesId: Long = 0
) : Serializable
