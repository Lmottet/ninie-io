package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import discord4j.core.`object`.Embed
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.ImmutableEmbedData

class Fart:AbstractCommand() {

    override fun respondTo(message: Message)= "https://c.tenor.com/6ksAhluvauUAAAAM/fart-summer-vibe.gif"

}