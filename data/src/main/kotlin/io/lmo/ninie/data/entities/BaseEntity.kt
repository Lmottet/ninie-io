package io.lmo.ninie.data.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdOn: Instant? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var lastModifiedOn: Instant? = null
)
