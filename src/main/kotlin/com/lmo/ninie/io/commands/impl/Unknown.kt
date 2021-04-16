package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Unknown : AbstractCommand() {

    override fun respondTo(message: Message) = "Unknown command"
}