package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import io.lmo.ninie.discord.services.SilenceService
import org.springframework.stereotype.Component

@Component
class Shh(private val silenceService: SilenceService) : MessageCommandBase {
    override val alias = Alias.Shh

    override fun response(message: Message): String {
        val guild = message.knownGuild() ?: return "Je peux pas faire ça en DM !"
        silenceService.keepQuiet(guild)
        return "Rhooo ça vaaa"
    }
}
