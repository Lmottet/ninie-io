package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.impl.CommandNames.SONGS
import com.lmo.ninie.io.models.commands.CommandDescription
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Songs : Command {
    override fun matches(commandDescription: CommandDescription): Boolean = commandDescription.action == SONGS

    override fun execute(commandDescription: CommandDescription): Mono<Message> =
            commandDescription.channel
                    .flatMap { chan -> chan.createMessage("") }
}