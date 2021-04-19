package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface MessageCommandBase : CommandBase {

    override fun respondTo(message: Message): Option<Mono<Unit>> =
        Option.of(message.restChannel.createMessage(response(message)).map { })

    fun response(message: Message): String

}