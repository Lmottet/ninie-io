package com.lmo.ninie.io.services

import com.lmo.ninie.io.commands.Command
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface CommandService {

    fun allCommands(): Array<Command>

    fun execute(command:Command, message: Message): Mono<Unit>

}