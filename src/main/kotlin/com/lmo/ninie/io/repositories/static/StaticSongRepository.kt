package com.lmo.ninie.io.repositories.static

import com.lmo.ninie.io.models.songs.*
import com.lmo.ninie.io.repositories.SongRepository
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service

@Service
class StaticSongRepository : SongRepository {

    private val all: List<Song> = listOf(
        EverybodyCat(),
        BearBrother(),
        Manon(),
        Tragedy(),
        BimBamBoum(),
        LittleBird()
    )

    override fun find(name: String): Option<Song> = all
        .find { name.equals(it.name, ignoreCase = true) }
        .option()

    override fun all(): List<Song> = all

    override fun any(): Song = all.random()
}