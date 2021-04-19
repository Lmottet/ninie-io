package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Unknown : MessageCommandBase {

    override fun response(message: Message) = "Unknown command"
}