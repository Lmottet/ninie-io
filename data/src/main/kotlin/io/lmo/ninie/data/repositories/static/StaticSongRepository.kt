package io.lmo.ninie.data.repositories.static

import io.lmo.ninie.data.songs.*
import org.springframework.stereotype.Component

@Component
class StaticSongRepository {

    private val all: List<Song> = listOf(
        EverybodyCat, BearBrother, Manon, Tragedy, BimBamBoum, LittleBird, Fatal, Dudule
    )

    fun find(name: String): Song? = all.find { name.equals(it.name, ignoreCase = true) }

    fun all(): List<Song> = all

    fun any(): Song = all.random()
}
