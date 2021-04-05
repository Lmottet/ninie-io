package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.MEOW
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Meow : Command {

    override fun commandName(): String = MEOW

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage("MEEEEOOOOOOW :heart:") }

    override fun description(): String = "Says hi !"

    override fun man(): String = "Just type it !"
}
