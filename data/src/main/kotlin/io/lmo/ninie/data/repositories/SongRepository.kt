package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.songs.Song

interface SongRepository {

    fun find(name: String): Song?

    fun all(): List<Song>

    fun any(): Song
}