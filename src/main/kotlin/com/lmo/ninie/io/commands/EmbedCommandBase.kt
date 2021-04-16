package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import reactor.core.publisher.Mono

abstract class EmbedCommandBase : CommandBase() {

    override fun respondTo(message: Message): Mono<Unit> = message.restChannel.createMessage(response(message)).map { }

    abstract fun response(message: Message): EmbedData
}