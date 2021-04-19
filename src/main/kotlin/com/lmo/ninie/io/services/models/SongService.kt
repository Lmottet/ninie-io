package com.lmo.ninie.io.services.models

import com.lmo.ninie.io.models.songs.Song
import io.vavr.control.Option

interface SongService {
    fun any(): Song

    fun from(name: String): Option<Song>

    fun all(): List<Song>
}