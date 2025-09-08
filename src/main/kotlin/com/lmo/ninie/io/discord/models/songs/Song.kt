package com.lmo.ninie.io.discord.models.songs

/**
 * Song name is used in sing command to pick a song
 * Song content to be sang by Ninie
 */
abstract class Song {
    abstract val name: String
    abstract val content: String
}
