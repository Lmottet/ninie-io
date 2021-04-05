package com.lmo.ninie.io.constants

import com.lmo.ninie.io.models.songs.BearBrother
import com.lmo.ninie.io.models.songs.EverybodyCat
import com.lmo.ninie.io.models.songs.Song
import io.vavr.control.Option

object Songs {
    val all: MutableList<Song> = mutableListOf(
            EverybodyCat(),
            BearBrother()
    )

    fun from(name: String): Option<Song> = Option.of(all.find { song -> song.name() == name })

    fun any(): Song {
        all.shuffle()
        return all[0]
    }
}