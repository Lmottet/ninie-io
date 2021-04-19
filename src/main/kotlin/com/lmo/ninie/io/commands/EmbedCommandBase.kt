package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface EmbedCommandBase : CommandBase {

    override fun respondTo(message: Message): Option<Mono<Unit>> =
        Option.of(message.restChannel.createMessage(response(message)).map { })

    fun response(message: Message): EmbedData
}