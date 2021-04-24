package com.lmo.ninie.io.models

import com.lmo.ninie.io.models.songs.Song
import io.vavr.control.Option

interface SongService {
    fun any(): Song

    fun find(name: String): Option<Song>

    fun all(): List<Song>
}