package io.lmo.ninie.data.repositories.static

import io.lmo.ninie.data.songs.BearBrother
import io.lmo.ninie.data.songs.BimBamBoum
import io.lmo.ninie.data.songs.Dudule
import io.lmo.ninie.data.songs.EverybodyCat
import io.lmo.ninie.data.songs.Fatal
import io.lmo.ninie.data.songs.LittleBird
import io.lmo.ninie.data.songs.Manon
import io.lmo.ninie.data.songs.Song
import io.lmo.ninie.data.songs.Tragedy
import org.springframework.stereotype.Repository

@Repository
class StaticSongRepository  {

    private val all: List<Song> = listOf(
        EverybodyCat(),
        BearBrother(),
        Manon(),
        Tragedy(),
        BimBamBoum(),
        LittleBird(),
        Fatal(),
        Dudule()
    )

    fun find(name: String): Song? = all.find { name.equals(it.name, ignoreCase = true) }

    fun all(): List<Song> = all

    fun any(): Song = all.random()
}