package com.lmo.ninie.io.models.songs

class EverybodyCat : Song {

    override fun name(): String = "EverybodyCat"

    override fun content(): String =
            """
                Tout le monde veut devenir un Cat :musical_note:,
                Parce qu'un chat - quand il est Cat :musical_note:,
                Retooooombe sur ses pattes :musical_note:
            """.trimIndent()

}