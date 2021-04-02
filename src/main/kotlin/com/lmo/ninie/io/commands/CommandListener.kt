package com.lmo.ninie.io.commands

import com.lmo.ninie.io.models.commands.Command
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface CommandListener {

    fun matches(command: Command): Boolean

    fun execute(command: Command): Mono<Message>

}