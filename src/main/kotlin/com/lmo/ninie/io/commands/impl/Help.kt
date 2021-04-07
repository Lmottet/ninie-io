package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandListeners
import com.lmo.ninie.io.constants.CommandNames.HELP
import com.lmo.ninie.io.constants.Emojis.HEART
import com.lmo.ninie.io.constants.MagicStrings.LINE_BREAKER
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Help : Command {

    override fun commandName(): String = HELP

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage.
                    channel.
                    flatMap { chan -> chan.createMessage(buildMessage(eventMessage)) }

    private fun buildMessage(eventMessage: Message):String{
       val arg = eventMessage.extractArg(1)
       return if(arg != null) explainCommand(arg) else listCommands()
    }

    private fun listCommands(): String = "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"// todo use multiline string instead

    private fun explainCommand(commandName: String):String =
        CommandListeners.
                find(commandName).
                man()

    override fun description(): String = "this command, for n00bs. Try 'help help' fore more"

    override fun man(): String = """
        optional : [command name]
        Details the purpose of a command
        """.trimIndent()

    private fun describeAllCommands(): String =
            CommandListeners.
                    all.
                    map { command -> command.commandName() + " - " + command.description() }.
                    joinToString(LINE_BREAKER)

}