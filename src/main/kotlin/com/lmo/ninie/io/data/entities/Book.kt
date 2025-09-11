package com.lmo.ninie.io.data.entities

import jakarta.persistence.*

@Entity
class Book(
    val title: String,
    val tome: Int,

    @OneToMany(mappedBy = "book", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorBooks: MutableSet<AuthorBook> = mutableSetOf(),

    @OneToMany(mappedBy = "book", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val seriesBook: MutableSet<SeriesBook> = mutableSetOf()
): BaseEntity() {
    fun addAuthor(author: Author) {
        val link = AuthorBook(author = author, book = this)
        authorBooks.add(link)
        author.authorBooks.add(link)
    }

    fun addSeries(series: Series) {
        val link = SeriesBook(series = series, book = this)
        seriesBook.add(link)
        series.seriesBook.add(link)
    }
}