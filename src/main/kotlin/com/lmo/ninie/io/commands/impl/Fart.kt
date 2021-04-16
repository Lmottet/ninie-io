package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.EmbedCommandBase
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.ImmutableEmbedData
import org.springframework.stereotype.Component

@Component
class Fart : EmbedCommandBase() {

    override fun response(message: Message) = ImmutableEmbedData
        .builder()
        .url("https://c.tenor.com/6ksAhluvauUAAAAM/fart-summer-vibe.gif")
        .build()
}