package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Cry : AbstractCommand() {

    override fun respondTo(message: Message) = respond(message,  "There there ! *pat* *pat*")
}