package com.lmo.ninie.io.dao

import com.lmo.ninie.io.models.songs.Song

interface SongDao {
    fun any(): Song

    fun find(name: String): Song?

    fun all(): List<Song>
}