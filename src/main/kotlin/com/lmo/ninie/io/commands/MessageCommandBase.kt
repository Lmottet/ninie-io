package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

abstract class MessageCommandBase : CommandBase() {

    override fun respondTo(message: Message): Mono<Unit> = message.restChannel.createMessage(response(message)).map { }

    abstract fun response(message: Message): String

}