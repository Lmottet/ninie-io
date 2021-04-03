package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.HELP
import com.lmo.ninie.io.models.commands.CommandDescription
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Help : Command {

    override fun matches(commandDescription: CommandDescription): Boolean = commandDescription.action == HELP

    override fun execute(commandDescription: CommandDescription): Mono<Message> =
            commandDescription.channel
                    .flatMap { chan -> chan.createMessage(buildMessage()) }

    private fun buildMessage(): String =
            """
                Ninie.IO is Helping ! :heart:
                Commands :
                $HELP - this command, for n00bs
            """.trimMargin()


}