package com.lmo.ninie.io.data.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class Series(
    val title: String,

    val isFinished: Boolean,

    @OneToMany(mappedBy = "series", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorSeries: MutableSet<AuthorSeries> = mutableSetOf(),

    @OneToMany(mappedBy = "series", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val seriesBook: MutableSet<SeriesBook> = mutableSetOf()

) : BaseEntity() {
    fun addAuthor(author: Author) {
        val link = AuthorSeries(author = author, series = this)
        authorSeries.add(link)
        author.authorSeries.add(link)
    }

    fun addBook(book: Book) {
        val link = SeriesBook(book = book, series = this)
        seriesBook.add(link)
        book.seriesBook.add(link)
    }
}
