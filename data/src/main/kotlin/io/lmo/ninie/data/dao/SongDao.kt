package io.lmo.ninie.data.dao

import io.lmo.ninie.data.songs.Song

interface SongDao {
    fun any(): Song

    fun find(name: String): Song?

    fun all(): List<Song>
}