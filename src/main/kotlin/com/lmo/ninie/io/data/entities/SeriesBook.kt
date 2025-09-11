package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class SeriesBook(
    @ManyToOne
    @JoinColumn(name = "series_id")
    val series: Series,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book
) : BaseEntity()