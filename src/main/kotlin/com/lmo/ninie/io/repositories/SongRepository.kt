package com.lmo.ninie.io.repositories

import com.lmo.ninie.io.models.songs.Song

interface SongRepository {

    fun find(name: String): Song?

    fun all(): List<Song>

    fun any(): Song
}