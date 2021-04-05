package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandListeners
import com.lmo.ninie.io.constants.CommandNames.HELP
import com.lmo.ninie.io.constants.Emojis.HEART
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Help : Command {

    override fun commandName(): String = HELP

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage(buildMessage()) }

    private fun buildMessage(): String = "Ninie.IO is Helping ! $HEART" + "\n"+ describeAllCommands()

    override fun description(): String = "this command, for n00bs."

    override fun man(): String = "optional : [command name]"

    private fun describeAllCommands(): String =
            CommandListeners
                    .all
                    .map { command -> command.commandName() + " - " + command.description() }
                    .joinToString("\n")

}