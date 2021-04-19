package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.MessageCommandBase
import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.constants.text.Emojis.HEART
import com.lmo.ninie.io.constants.text.MagicStrings.LINE_BREAKER
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.services.commands.AliasService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Help(
    val aliasService: AliasService
) : MessageCommandBase {

    override fun response(message: Message): String {
        val aliasToAssist = message.extractArg(1)
        return if (aliasToAssist.isNullOrEmpty()) listCommands() else explainCommand(aliasToAssist)
    }

    private fun listCommands(): String =
        "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"// todo use multiline string instead

    private fun explainCommand(commandName: String): String =
        aliasService
            .find(commandName)
            .map { it.manual }
            .getOrElse("Cannot explain unknown command $commandName")

    private fun describeAllCommands(): String =
        Alias.all().joinToString(LINE_BREAKER) { it.defaultAlias + " - " + it.description }

}