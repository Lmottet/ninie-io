package com.lmo.ninie.io.models.commands.sing

import com.lmo.ninie.io.models.commands.sing.songs.EverybodyCat
import io.vavr.collection.Set
import io.vavr.kotlin.hashSet

object Songs {
    val all: Set<Song> = hashSet(
            EverybodyCat()
    )

    fun from(name: String): Song = all.find { song -> song.name() == name }.get()
}