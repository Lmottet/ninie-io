package io.lmo.ninie.discord.interactions.reactions

import io.lmo.ninie.discord.KnownGuild

data class TriggerRule(
    val keywords: List<String>,
    val guilds: Set<KnownGuild>? = null,
    val response: String
)
