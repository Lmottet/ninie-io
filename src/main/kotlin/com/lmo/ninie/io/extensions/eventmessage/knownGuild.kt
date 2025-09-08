package com.lmo.ninie.io.extensions.eventmessage


import com.lmo.ninie.io.models.KnownGuild
import discord4j.core.`object`.entity.Message

fun Message.knownGuild(): KnownGuild {
    return KnownGuild.from(this.guildId.get())
}