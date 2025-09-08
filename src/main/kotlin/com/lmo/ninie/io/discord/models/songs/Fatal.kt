package com.lmo.ninie.io.discord.models.songs

import com.lmo.ninie.io.constants.text.Emojis.MUSICAL_NOTE

class Fatal(
    override val name: String = "Fatal",
    override val content: String = """
                T'es trop mon style, t'es trop mon style $MUSICAL_NOTE
                T'es trop mon style de mec $MUSICAL_NOTE
                J'aime trop ton boule, j'aime trop ton boule $MUSICAL_NOTE
                J'aime trop ton boule de mec $MUSICAL_NOTE
    """.trimIndent()
) : Song()