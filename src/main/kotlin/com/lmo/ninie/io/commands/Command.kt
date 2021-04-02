package com.lmo.ninie.io.commands

import com.lmo.ninie.io.models.commands.CommandDescription
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface Command {

    fun matches(commandDescription: CommandDescription): Boolean

    fun execute(commandDescription: CommandDescription): Mono<Message>

}