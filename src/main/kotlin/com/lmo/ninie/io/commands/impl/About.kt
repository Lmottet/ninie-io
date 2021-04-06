package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.ABOUT
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class About : Command {
    override fun commandName(): String = ABOUT

    override fun description(): String = "Describes ninie-io"

    override fun man(): String = "Just type it !"

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel.flatMap { chan -> chan.createMessage(message()) }

    private fun message() = """
        Ninie-io is a discord bot, written in kotlin.
        More on : https://github.com/Lmottet/ninie-io
        """.trimIndent()

}