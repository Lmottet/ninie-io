package com.lmo.ninie.io.repositories

import com.lmo.ninie.io.models.songs.Song
import io.vavr.control.Option

interface SongRepository {

    fun find(name: String): Option<Song>

    fun all(): List<Song>
}