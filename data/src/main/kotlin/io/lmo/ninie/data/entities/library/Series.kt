package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
class Series(
    @Column(nullable = false, length = 60)
    val title: String,
    val isFinished: Boolean,

    @OneToMany(mappedBy = "series", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorSeries: MutableSet<AuthorSeries> = mutableSetOf(),

    @OneToMany(mappedBy = "series", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val seriesBook: MutableSet<SeriesBook> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "series_genre",
        joinColumns = [JoinColumn(name = "series_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    val genres: MutableSet<Genre> = mutableSetOf()

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
