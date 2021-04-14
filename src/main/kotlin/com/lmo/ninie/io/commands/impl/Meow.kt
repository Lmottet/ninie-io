package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.Emojis.HEART
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Meow : AbstractCommand(Command.MEOW) {

    override fun respondTo(message: Message) = "MEEEEOOOOOOW $HEART"

}
