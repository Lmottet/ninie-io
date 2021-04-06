package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.UNKNOWN
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Unknown : Command {
    override fun commandName(): String = UNKNOWN

    override fun description(): String = "Fallback command on unknown action"

    override fun man(): String = "Why are you doing this to me ?"

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage("Unknown command") }
}