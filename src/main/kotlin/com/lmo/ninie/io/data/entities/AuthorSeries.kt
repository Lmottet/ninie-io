package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class AuthorSeries(

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @JoinColumn(name = "series_id")
    val series: Series,
) : BaseEntity()
