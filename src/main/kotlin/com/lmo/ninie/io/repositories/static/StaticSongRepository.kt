package com.lmo.ninie.io.repositories.static

import com.lmo.ninie.io.models.songs.*
import com.lmo.ninie.io.repositories.SongRepository
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
        Fatal()
    )

    override fun find(name: String): Song? = all.find { name.equals(it.name, ignoreCase = true) }

    override fun all(): List<Song> = all

    override fun any(): Song = all.random()
}