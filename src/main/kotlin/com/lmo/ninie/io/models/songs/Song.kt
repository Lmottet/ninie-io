package com.lmo.ninie.io.models.songs

/**
 * Song behavior
 */
interface Song {
    /**
     * Song name is used in sing command to pick a song
     */
    fun name(): String

    /**
     * Song content to be sang by Ninie
     */
    fun content(): String
}