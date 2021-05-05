package com.lmo.ninie.io.interactions.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.MessageData
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface EmbedCommandBase : CommandBase<MessageData> {

    override fun respondTo(message: Message): Option<Mono<MessageData>> =
        Option.of(message.restChannel.createMessage(response(message)))

    fun response(message: Message): EmbedData
}