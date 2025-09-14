package io.lmo.ninie.data.songs

import io.lmo.ninie.data.constants.text.Emojis.MUSICAL_NOTE

data class Dudule(
    override val name: String = "Dudule",
    override val content: String = """
        C'est la grosse bite a Dudule $MUSICAL_NOTE
        J'la prends, j'la suce, elle m'encule $MUSICAL_NOTE
        Ah les amies, ah c'que c'est bon $MUSICAL_NOTE
        Quand il m'la carre dans l'oignon ! $MUSICAL_NOTE
        """.trimIndent()
) : Song()