package io.lmo.ninie.data.songs

import io.lmo.ninie.data.constants.text.Emojis.MUSICAL_NOTE

object LittleBird : Song(
    name = "LittleBird",
    content = """
        Mon petit oiseau a pris sa volée $MUSICAL_NOTE
        A pris sa... A la volette A pris sa volée $MUSICAL_NOTE
        Est allé se mettre sur un oranger $MUSICAL_NOTE
        Sur un o... A la volette Sur un oranger. $MUSICAL_NOTE
    """.trimIndent()
)
