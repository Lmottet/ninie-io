package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractMessageCommand
import com.lmo.ninie.io.constants.Emojis.HEART
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Meow : AbstractMessageCommand() {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"
}
