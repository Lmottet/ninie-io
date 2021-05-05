package com.lmo.ninie.io.repositories.static

import com.lmo.ninie.io.models.songs.*
import io.vavr.control.Option
import org.springframework.stereotype.Service
import com.lmo.ninie.io.repositories.SongRepository

@Service
class StaticSongRepository : SongRepository {

    private val all: MutableList<Song> = mutableListOf(
        EverybodyCat(),
        BearBrother(),
        Manon(),
        Tragedy(),
        BimBamBoum(),
        LittleBird()
    )

    override fun find(name: String): Option<Song> {
        TODO("Not yet implemented")
    }

    override fun all(): List<Song> = all
}