package com.lmo.ninie.io.interactions.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.MessageData
import io.vavr.control.Option
import io.vavr.kotlin.option
import reactor.core.publisher.Mono

interface EmbedCommandBase : CommandBase<MessageData> {

    override fun respondTo(message: Message): Option<Mono<MessageData>> =
        message.restChannel.createMessage(response(message)).option()

    fun response(message: Message): EmbedData
}