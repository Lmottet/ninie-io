package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.Emojis.HEART
import com.lmo.ninie.io.constants.MagicStrings.LINE_BREAKER
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.services.AliasService
import com.lmo.ninie.io.services.CommandService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Help(
    val commandService: CommandService,
    val aliasService: AliasService
) : AbstractCommand(Command.HELP) {

    override fun respondTo(message: Message): String {
        val aliasToAssist = message.extractArg(1)
        return if (aliasToAssist.isNullOrEmpty()) listCommands() else explainCommand(aliasToAssist)
    }

    private fun listCommands(): String =
        "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"// todo use multiline string instead

    private fun explainCommand(commandName: String): String =
        aliasService
            .find(commandName)
            .map { it.description }
            .getOrElse("Cannot explain unknown command $commandName")

    private fun describeAllCommands(): String =
        commandService.allCommands().joinToString(LINE_BREAKER) { it.defaultAlias + " - " + it.description }

}