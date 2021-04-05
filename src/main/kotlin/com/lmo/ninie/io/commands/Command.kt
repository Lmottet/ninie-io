package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface Command {

    fun commandName(): String

    fun description(): String

    fun man(): String

    fun execute(eventMessage: Message): Mono<Message>

}