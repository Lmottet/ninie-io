package io.lmo.ninie.discord.eventmessage

import io.lmo.ninie.discord.KnownGuild
import discord4j.core.`object`.entity.Message

fun Message.knownGuild(): KnownGuild? {
    return KnownGuild.fromValue(this.guildId.get())
}