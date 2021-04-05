package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandListeners
import com.lmo.ninie.io.commands.CommandNames.HELP
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Help : Command {

    override fun commandName(): String = HELP

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage(buildMessage()) }

    private fun buildMessage(): String = "Ninie.IO is Helping ! :heart:" + describeAllCommands()

    override fun description(): String = "this command, for n00bs."

    override fun man(): String = "Add the name of the command you wish to have details about"

    private fun describeAllCommands(): String =
            CommandListeners
                    .all
                    .map { command -> command.commandName() + " - " + command.description() }
                    .joinToString("\n")

}