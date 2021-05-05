package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.text.Emojis.MUSICAL_NOTE

data class EverybodyCat(
    override val name: String = "EverybodyCat",
    override val content: String = """
        Tout le monde veut devenir un Cat $MUSICAL_NOTE
        Parce qu'un chat - quand il est Cat $MUSICAL_NOTE
        Retooooombe sur ses pattes $MUSICAL_NOTE
        """.trimIndent()
) : Song()