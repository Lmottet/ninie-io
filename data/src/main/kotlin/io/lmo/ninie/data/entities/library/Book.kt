package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.*

@Entity
class Book(
    val title: String,
    val tome: Int,

    @OneToMany(mappedBy = "book", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorBooks: MutableSet<AuthorBook> = mutableSetOf(),

    @OneToMany(mappedBy = "book", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val seriesBook: MutableSet<SeriesBook> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "book_genre",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    val genres: MutableSet<Genre> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "book_theme",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "theme_id")]
    )
    val themes: MutableSet<Theme> = mutableSetOf()
) : BaseEntity() {
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