package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractMessageCommand
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class About : AbstractMessageCommand() {

    override fun response(message: Message) = """
        Ninie-io is a discord bot, written in kotlin.
        More on : https://github.com/Lmottet/ninie-io
        """.trimIndent()
}