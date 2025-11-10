package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import io.lmo.ninie.discord.services.SilenceService
import org.springframework.stereotype.Component

@Component
class Shh(val silenceService: SilenceService) : MessageCommandBase {

    override fun response(message: Message): String {
        silenceService.keepQuiet(message.knownGuild()!!)
        return "Rhooo ça vaaa"
    }
}
