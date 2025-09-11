package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class SeriesBook(
    @Id @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "series_id")
    val series: Series,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book
)