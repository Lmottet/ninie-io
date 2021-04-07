package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.CRY
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Cry :Command {
    override fun commandName(): String = CRY

    override fun description(): String = "Get some compassion"

    override fun man(): String = "Just type it !"

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage.
                    channel.
                    flatMap { chan -> chan.createMessage("There there ! *pat* *pat*") }
}