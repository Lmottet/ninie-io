package com.lmo.ninie.io.models.songs

class BearBrother : Song {
    override fun name(): String = "BearBrother"

    override fun content(): String =
            """
                Dites à mes amis que je m'en vais :musical_note:,
                Je pars vers de nouveaux pays :musical_note:,
                Où le ciel est tout bleu, dites que je m'en vais :musical_note:,
                Et c'est tout ce qui compte dans ma vie :musical_note:
            """.trimIndent()
}