package com.lmo.ninie.io.data.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val firstName: String,
    val lastName: String,

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorBooks: MutableList<AuthorBook> = mutableListOf(),

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorSeries: MutableList<AuthorSeries> = mutableListOf()

) {
    fun addSeries(series: Series) {
        val link = AuthorSeries(author = this, series = series)
        authorSeries.add(link)
        series.authorSeries.add(link)
    }
}