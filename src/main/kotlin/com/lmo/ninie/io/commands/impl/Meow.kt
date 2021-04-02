package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.CommandListener
import com.lmo.ninie.io.commands.impl.CommandNames.MEOW
import com.lmo.ninie.io.models.commands.Command
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Meow : CommandListener {
    override fun matches(command: Command): Boolean = command.action == MEOW

    override fun execute(command: Command): Mono<Message> =
            command.channel
                    .flatMap { chan -> chan.createMessage("MEEEEOOOOOOW :heart:") }
}
