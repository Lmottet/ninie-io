package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.MEOW
import com.lmo.ninie.io.constants.Emojis.HEART
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Meow : Command {

    override fun commandName(): String = MEOW

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage.
                    channel.
                    flatMap { chan -> chan.createMessage("MEEEEOOOOOOW $HEART") }

    override fun description(): String = "Say hi !"

    override fun man(): String = "Just type it !"
}
