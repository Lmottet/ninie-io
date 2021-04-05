package com.lmo.ninie.io.models.songs

class EverybodyCat : Song {

    override fun name(): String = "EverybodyCat"

    override fun content(): String =
            """
                Everybody wants to be a cat
            """.trimIndent()

}