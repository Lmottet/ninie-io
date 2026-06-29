package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class About : MessageCommandBase {
    override val alias = Alias.About
    override val description = "Learn more about ninie.io"
    override val manual = "Just type it !"
    override fun response(message: Message) = """
        Bip boop. Boop bip ?
        https://github.com/Lmottet/ninie-io
    """.trimIndent()
}
