package com.lmo.ninie.io.models.impl

import com.lmo.ninie.io.models.songs.*
import com.lmo.ninie.io.models.SongService
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SongServiceImpl : SongService {

    private val all: MutableList<Song> = mutableListOf(
        EverybodyCat(),
        BearBrother(),
        Manon(),
        Tragedy(),
        BimBamBoum(),
        LittleBird()
    )

    override fun from(name: String): Option<Song> = all.find { song -> song.name == name }.option()

    override fun any(): Song {
        all.shuffle()
        return all[0]
    }

    override fun all(): List<Song> = all.stream().collect(Collectors.toList())
}