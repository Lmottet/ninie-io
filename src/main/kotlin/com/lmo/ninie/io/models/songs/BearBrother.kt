package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.Emojis.MUSICAL_NOTE

class BearBrother : Song {
    override fun name(): String = "BearBrother"

    override fun content(): String =
            """
                Dites à mes amis que je m'en vais $MUSICAL_NOTE
                Je pars vers de nouveaux pays $MUSICAL_NOTE
                Où le ciel est tout bleu, dites que je m'en vais $MUSICAL_NOTE
                Et c'est tout ce qui compte dans ma vie $MUSICAL_NOTE
            """.trimIndent()
}