package com.lmo.ninie.io.data.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Series(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,

    val isFinished: Boolean,

    @OneToMany(mappedBy = "series")
    val authorSeries: MutableSet<AuthorSeries> = mutableSetOf()
)
