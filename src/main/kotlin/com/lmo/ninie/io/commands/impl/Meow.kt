package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.MessageCommandBase
import com.lmo.ninie.io.constants.text.Emojis.HEART
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Meow : MessageCommandBase {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"
}
