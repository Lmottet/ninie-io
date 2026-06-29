package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.constants.text.Emojis.HEART
import io.lmo.ninie.data.constants.text.MagicStrings.LINE_BREAKER
import io.lmo.ninie.discord.eventmessage.extractArg
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import io.lmo.ninie.discord.services.AliasService
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
class Help(@param:Lazy private val aliasService: AliasService) : MessageCommandBase {
    override val alias = Alias.Help
    override val description = "This command, for n00bs. Try 'help help' for more"
    override val manual = "optional : [command name]\nPick a command you wish to learn more about"

    override fun response(message: Message): String {
        val aliasToAssist = message.extractArg(1)
        return if (aliasToAssist.isNullOrEmpty()) listCommands() else explainCommand(aliasToAssist)
    }

    private fun listCommands(): String =
        "Ninie.IO is Helping ! $HEART$LINE_BREAKER$LINE_BREAKER${describeAllCommands()}"

    private fun explainCommand(commandName: String): String =
        aliasService.find(commandName)?.manual ?: listCommands()

    private fun describeAllCommands(): String =
        aliasService.all()
            .filter { it.alias != Alias.Unknown }
            .joinToString(LINE_BREAKER) { "${it.alias.defaultAlias} - ${it.description}" }
}
