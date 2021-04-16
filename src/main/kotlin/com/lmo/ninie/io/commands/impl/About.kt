package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class About : AbstractCommand() {

    override fun respondTo(message: Message): String = """
        Ninie-io is a discord bot, written in kotlin.
        More on : https://github.com/Lmottet/ninie-io
        """.trimIndent()
}