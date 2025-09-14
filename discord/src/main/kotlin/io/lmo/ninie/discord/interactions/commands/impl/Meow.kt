package io.lmo.ninie.discord.interactions.commands.impl

import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.constants.text.Emojis.HEART
import org.springframework.stereotype.Component

@Component
class Meow : MessageCommandBase {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"
}
