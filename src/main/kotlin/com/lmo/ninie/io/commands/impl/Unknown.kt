package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractMessageCommand
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Unknown : AbstractMessageCommand() {

    override fun response(message: Message) = "Unknown command"
}