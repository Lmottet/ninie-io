package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Cry : MessageCommandBase {

    override fun response(message: Message) = "There there ! *pat* *pat*"
}