package com.lmo.ninie.io.dao

import com.lmo.ninie.io.models.songs.Song
import io.vavr.control.Option

interface SongDao {
    fun any(): Song

    fun find(name: String): Option<Song>

    fun all(): List<Song>
}