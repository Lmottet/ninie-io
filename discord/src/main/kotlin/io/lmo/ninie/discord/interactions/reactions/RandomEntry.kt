package io.lmo.ninie.discord.interactions.reactions

import io.lmo.ninie.discord.KnownGuild

sealed class RandomEntry(open val guilds: Set<KnownGuild>? = null) {
    data class TextEntry(val text: String, override val guilds: Set<KnownGuild>? = null) : RandomEntry(guilds)
    data class EmbedEntry(val imageUrl: String, override val guilds: Set<KnownGuild>? = null) : RandomEntry(guilds)
}
