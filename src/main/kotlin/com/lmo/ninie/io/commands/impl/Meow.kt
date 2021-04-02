package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.impl.CommandNames.MEOW
import com.lmo.ninie.io.models.commands.CommandDescription
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Meow : Command {
    override fun matches(commandDescription: CommandDescription): Boolean = commandDescription.action == MEOW

    override fun execute(commandDescription: CommandDescription): Mono<Message> =
            commandDescription.channel
                    .flatMap { chan -> chan.createMessage("MEEEEOOOOOOW :heart:") }
}
