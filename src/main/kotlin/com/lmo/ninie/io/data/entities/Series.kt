package com.lmo.ninie.io.data.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Series(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,

    val isFinished: Boolean,

    @OneToMany(mappedBy = "series", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val authorSeries: MutableSet<AuthorSeries> = mutableSetOf()
) {
    fun addAuthor(author: Author) {
        val link = AuthorSeries(author = author, series = this)
        authorSeries.add(link)
        author.authorSeries.add(link)
    }
}
