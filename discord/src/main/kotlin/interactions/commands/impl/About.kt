package com.lmo.ninie.io.discord.interactions.commands.impl

import com.lmo.ninie.io.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class About : MessageCommandBase {

    override fun response(message: Message) = """
        Bip boop. Boop bip ?
        https://github.com/Lmottet/ninie-io
        """.trimIndent()
}