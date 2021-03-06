package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.text.Emojis.MUSICAL_NOTE

data class Manon(
    override val name: String = "Manon",
    override val content: String = """
        Manon la gueuse ne porte jamais de culotte $MUSICAL_NOTE
        Chevalier sors ton dard et décalotte $MUSICAL_NOTE
        Et bourre la ribaude, fourre-z’y ta rapière $MUSICAL_NOTE
        """.trimIndent()
) : Song()
