package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class About : MessageCommandBase {

    override fun response(message: Message) = """
        Ninie-io is a discord bot, written in kotlin.
        More on : https://github.com/Lmottet/ninie-io
        """.trimIndent()
}