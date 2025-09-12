package com.lmo.ninie.io.data.dao

import com.lmo.ninie.io.discord.models.songs.Song

interface SongDao {
    fun any(): Song

    fun find(name: String): Song?

    fun all(): List<Song>
}