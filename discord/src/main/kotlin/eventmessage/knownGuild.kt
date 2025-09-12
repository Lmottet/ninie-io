package com.lmo.ninie.io.discord.eventmessage

import KnownGuild
import discord4j.core.`object`.entity.Message

fun Message.knownGuild(): KnownGuild? {
    return KnownGuild.fromValue(this.guildId.get())
}