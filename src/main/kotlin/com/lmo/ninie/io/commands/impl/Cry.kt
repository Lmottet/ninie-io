package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.CommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Cry : CommandBase() {

    override fun respondTo(message: Message) = respond(message,  "There there ! *pat* *pat*")
}