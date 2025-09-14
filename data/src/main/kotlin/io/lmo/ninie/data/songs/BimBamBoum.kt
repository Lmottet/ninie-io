package io.lmo.ninie.data.songs

import io.lmo.ninie.data.constants.text.Emojis.MUSICAL_NOTE

data class BimBamBoum(
    override val name: String = "BimBamBoum",
    override val content: String = """
        Et ça fait bim-bam-boum, ça fait -pschhht!- et ça fait "vroum" $MUSICAL_NOTE
        Ça fait bim-bam-boum, dans ma tête y a tout qui tourne $MUSICAL_NOTE
        Ça fait "chut!" et puis "blabla!", ça fait, comme ci-comme ça $MUSICAL_NOTE
    """.trimIndent()
) : Song()