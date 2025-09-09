package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class AuthorSeries(
    @Id @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @JoinColumn(name = "series_id")
    val series: Series,
)
