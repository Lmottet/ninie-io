package io.lmo.ninie.discord.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.callsNinie(prefix: String): Boolean {
    return !this.isBotAuthor() && this.content.startsWith(prefix) && this.content.length > 1
}