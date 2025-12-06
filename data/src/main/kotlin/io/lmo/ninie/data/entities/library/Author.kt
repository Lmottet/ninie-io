package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class Author(
    @Column(nullable = false, length = 60)
    val firstName: String,
    @Column(nullable = false, length = 60)
    val lastName: String,

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorSeries: MutableList<AuthorSeries> = mutableListOf(),

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorBooks: MutableList<AuthorBook> = mutableListOf()
) : BaseEntity() {

    fun addSeries(series: Series) {
        val link = AuthorSeries(author = this, series = series)
        authorSeries.add(link)
        series.authorSeries.add(link)
    }

    fun addBook(book: Book) {
        val link = AuthorBook(author = this, book = book)
        authorBooks.add(link)
        book.authorBooks.add(link)
    }
}