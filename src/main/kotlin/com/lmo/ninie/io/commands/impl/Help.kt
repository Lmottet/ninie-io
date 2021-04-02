package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.CommandListener
import com.lmo.ninie.io.commands.impl.CommandNames.HELP
import com.lmo.ninie.io.models.commands.Command
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

class Help : CommandListener {

    private val lineBreak = "\n"

    override fun matches(command: Command): Boolean = command.action == HELP

    override fun execute(command: Command): Mono<Message> =
            command.channel
                    .flatMap { chan -> chan.createMessage("Ninie.IO is Helping ! :heart: \n help command") }

    private fun buildMessage(): String =
            """"
                Ninie.IO is Helping ! :heart:
                Commands :
                $HELP - this command, for n00bs
            """.trimMargin()



}