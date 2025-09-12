package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.discord.models.songs.Song

interface SongRepository {

    fun find(name: String): Song?

    fun all(): List<Song>

    fun any(): Song
}