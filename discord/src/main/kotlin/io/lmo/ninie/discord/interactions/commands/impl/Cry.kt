package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Cry : MessageCommandBase {
    override val alias = Alias.Cry
    override val description = "Get some compassion"
    override val manual = "Just type it !"
    override fun response(message: Message) = "There there ! *pat* *pat*"
}
