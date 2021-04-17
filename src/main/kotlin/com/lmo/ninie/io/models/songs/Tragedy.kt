package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.Emojis.MUSICAL_NOTE

class Tragedy(
    override val name: String = "Tragedy",
    override val content: String = """
            Est-ce que tu m'entends, hey ho $MUSICAL_NOTE
            Est-ce que tu me sens, hey ho $MUSICAL_NOTE
            Touche-moi je suis là, hey ho ho ho ho $MUSICAL_NOTE
            S'il te plait réponds-moi, hey ho $MUSICAL_NOTE
    """.trimIndent()
) : Song()
