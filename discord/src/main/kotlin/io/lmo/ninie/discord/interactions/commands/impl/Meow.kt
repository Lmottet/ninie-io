package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.constants.text.Emojis.HEART
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Meow : MessageCommandBase {
    override val alias = Alias.Meow
    override val description = "Say hi !"
    override val manual = "Just type it !"
    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"
}
