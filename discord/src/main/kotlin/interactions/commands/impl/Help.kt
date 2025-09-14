package com.lmo.ninie.io.discord.interactions.commands.impl

import com.lmo.ninie.io.data.constants.text.Emojis.HEART
import com.lmo.ninie.io.data.constants.text.MagicStrings.LINE_BREAKER
import com.lmo.ninie.io.discord.eventmessage.extractArg
import com.lmo.ninie.io.discord.interactions.commands.Alias
import com.lmo.ninie.io.discord.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.discord.services.AliasService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Lazy

@Component
class Help(@param:Lazy val aliasService: AliasService) : MessageCommandBase {

    override fun response(message: Message): String {
        val aliasToAssist = message.extractArg(1)
        return if (aliasToAssist.isNullOrEmpty()) listCommands() else explainCommand(aliasToAssist)
    }

    private fun listCommands(): String =
        "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"// todo use multiline string instead

    private fun explainCommand(commandName: String): String =
        aliasService.find(commandName)?.manual ?: listCommands()

    private fun describeAllCommands(): String =
        aliasService.all()
            .filter { it != Alias.Unknown }
            .joinToString(LINE_BREAKER) { it.defaultAlias + " - " + it.description }

}