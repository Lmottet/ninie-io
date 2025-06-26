package com.lmo.ninie.io.dao

import com.lmo.ninie.io.models.songs.Song
import java.util.*

interface SongDao {
    fun any(): Song

    fun find(name: String): Optional<Song>

    fun all(): List<Song>
}