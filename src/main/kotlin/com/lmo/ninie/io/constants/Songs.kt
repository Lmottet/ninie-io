package com.lmo.ninie.io.constants

import com.lmo.ninie.io.models.songs.*
import io.vavr.control.Option

object Songs {
    val all: MutableList<Song> = mutableListOf(
            EverybodyCat(),
            BearBrother(),
            Manon(),
            Tragedy(),
            BimBamBoum(),
            LittleBird()
    )

    fun from(name: String): Option<Song> = Option.of(all.find { song -> song.name() == name })

    fun any(): Song {
        all.shuffle()
        return all[0]
    }
}