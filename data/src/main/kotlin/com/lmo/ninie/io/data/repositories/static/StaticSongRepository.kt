package com.lmo.ninie.io.data.repositories.static

import com.lmo.ninie.io.data.repositories.SongRepository
import com.lmo.ninie.io.discord.models.songs.*
import com.lmo.ninie.io.discord.models.songs.Song
import org.springframework.stereotype.Service

@Service
class StaticSongRepository : SongRepository {

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

    override fun find(name: String): Song? = all.find { name.equals(it.name, ignoreCase = true) }

    override fun all(): List<Song> = all

    override fun any(): Song = all.random()
}