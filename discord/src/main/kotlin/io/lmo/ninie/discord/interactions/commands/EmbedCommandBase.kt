package io.lmo.ninie.discord.interactions.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.MessageData
import reactor.core.publisher.Mono

interface EmbedCommandBase : CommandBase {

    override fun respondTo(message: Message): Mono<MessageData> =
        message.restChannel.createMessage(response(message))

    fun response(message: Message): EmbedData
}