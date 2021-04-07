package com.lmo.ninie.io.models.songs

import com.lmo.ninie.io.constants.Emojis.MUSICAL_NOTE

class BimBamBoum : Song {
    override fun name() = "BimBamBoum"

    override fun content() = """
        Et ça fait bim-bam-boum, ça fait -pschhht!- et ça fait "vroum" $MUSICAL_NOTE
        Ça fait bim-bam-boum, dans ma tête y a tout qui tourne $MUSICAL_NOTE
        Ça fait "chut!" et puis "blabla!", ça fait, comme ci-comme ça $MUSICAL_NOTE
    """.trimIndent()
}