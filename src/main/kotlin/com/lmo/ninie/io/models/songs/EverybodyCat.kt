package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.Emojis.MUSICAL_NOTE

class EverybodyCat : Song {

    override fun name(): String = "EverybodyCat"

    override fun content(): String =
        """
                Tout le monde veut devenir un Cat $MUSICAL_NOTE
                Parce qu'un chat - quand il est Cat $MUSICAL_NOTE
                Retooooombe sur ses pattes $MUSICAL_NOTE
            """.trimIndent()

}