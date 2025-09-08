package com.lmo.ninie.io.discord.interactions.commands.impl

import com.lmo.ninie.io.constants.text.Emojis.HEART
import com.lmo.ninie.io.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Meow : MessageCommandBase {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"
}
