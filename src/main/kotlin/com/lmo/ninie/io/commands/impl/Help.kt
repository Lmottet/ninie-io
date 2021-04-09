package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandListeners
import com.lmo.ninie.io.constants.CommandNames.HELP
import com.lmo.ninie.io.constants.Emojis.HEART
import com.lmo.ninie.io.constants.MagicStrings.LINE_BREAKER
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import discord4j.core.`object`.entity.Message

class Help : AbstractCommand(
        HELP,
        "this command, for n00bs. Try 'help help' fore more",
        """
        optional : [command name]
        Details the purpose of a command
        """.trimIndent()
) {

    override fun response(message: Message): String {
        val arg = message.extractArg(1)
        return if (arg != null) explainCommand(arg) else listCommands()
    }

    private fun listCommands(): String = "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"// todo use multiline string instead

    private fun explainCommand(commandName: String): String = CommandListeners.find(commandName).man

    private fun describeAllCommands(): String =
            CommandListeners
                    .all
                    .map { command -> command.name + " - " + command.description }
                    .joinToString(LINE_BREAKER)

}